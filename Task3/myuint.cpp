#include <math.h>
#include <vector>
#include "myuint.hpp"

template <int T>
myuint<T>::myuint(int num)
{

    try
    {
        floor(log2(T)) == log2(T)
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << '\n myuint only support unsigned integers with 2^n bits \n';
    }

    if (T <= 0)
    {
        std::cerr << '\n myuint only support unsigned integers with 2^n bits \n';
    }

    myuint<T>::number = getNumberAsString(num);

    while (number.size() != T)
    {
        number.insert(0, "0");
    }
}
template <int T>
myuint<T>::myuint()
{
    try
    {
        floor(log2(T)) == log2(T)
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << '\n myuint only support unsigned integers with 2^n bits \n';
    }

    if (T <= 0)
    {
        std::cerr << '\n myuint only support unsigned integers with 2^n bits \n';
    }
}

template <int T>
void myuint<T>::setNumber(std::string num)
{
    myuint<T>::number = num;
}

template <int T>
std::string myuint<T>::getNumber()
{
    return myuint<T>::number;
}

std::string getNumberAsString(int n)
{
    std::string s = "";

    while (n != 0)
    {
        s = (n % 2 == 0 ? "0" : "1") + s;
        n /= 2;
    }
    return s;
}

template <int T>
myuint<T> myuint<T>::operator+(myuint<T> num)
{
    std::string num1 = myuint<T>::number;
    std::string num2 = num.getNumber();
    std::string result = "";

    int temp = 0;
    int size_num1 = num1.size() - 1;
    int size_num2 = num2.size() - 1;
    while (size_num1 >= 0 || size_num2 >= 0 || temp == 1)
    {
        temp += ((size_num1 >= 0) ? num1[size_num1] - '0' : 0);
        temp += ((size_num2 >= 0) ? num2[size_num2] - '0' : 0);
        result = char(temp % 2 + '0') + result;
        temp /= 2;
        size_num1--;
        size_num2--;
    }

    myuint<T> ans;
    if (result.size() > T)
    {
        result = result.substr(result.size() - T, result.size());
    }

    ans.setNumber(result);
    return ans;
    ;
}

template <int T>
myuint<T> myuint<T>::operator-(myuint<T> num)
{
    std::string toSubtract = num.getNumber();

    for (int i = 0; i < toSubtract.size(); i++)
    {
        toSubtract[i] == '0' ? (toSubtract[i] = '1') : (toSubtract[i] = '0');
    }

    num.setNumber(toSubtract);
    num += 1;

    return myuint<T>::operator+(num);
}

template <int T>
myuint<T> myuint<T>::operator-=(myuint<T> num)
{
    return *this = *this - num;
}

template <int T>
myuint<T> myuint<T>::operator+=(myuint<T> num)
{
    return *this = *this + num;
}