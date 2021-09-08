#include <math.h>
#include <vector>
#include "myuint.hpp"

/* Things to check:
 - Why calling the same method from a differnt "main.cpp" class results in an undefined reference error
 - Why an error is also given when trying to fit a smaller number into a larger on example (a myuint<1024> into a myuing<2048>)
 */

// Converts a decimal number into a String made up of the binary convertion of the given number
std::string decimalToBinary(int dec)
{
    std::string bin = "";

    while (dec != 0)
    {
        bin = (dec % 2 == 0 ? "0" : "1") + bin;
        dec /= 2;
    }

    return bin;
}

// Constructor accepting an integer which is converted to a myuint
template <int T>
myuint<T>::myuint(int num)
{
    // Checks if correct number of bits (2^n) are present, otherwise an exception is thrown
    try
    {
        floor(log2(T)) == log2(T);
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << "\n myuint only support unsigned integers with 2^n bits" << std::endl;
    }

    if (T <= 0)
    {
        std::cerr << "\n myuint only support unsigned integers with 2^n bits" << std::endl;
    }

    myuint<T>::number = decimalToBinary(num);

    // Filling in the remaining spaces with 0 to keep size T
    while (number.size() != T)
    {
        number.insert(0, "0");
    }
}

// Constructor accepting no parameters which initialises an empty myuint
template <int T>
myuint<T>::myuint()
{

    try
    {
        floor(log2(T)) == log2(T);
    }
    catch (const std::exception &e)
    {
        std::cerr << e.what() << "\n myuint only support unsigned integers with 2^n bits" << std::endl;
    }

    if (T <= 0)
    {
        std::cerr << "\n myuint only support unsigned integers with 2^n bits" << std::endl;
    }
}

// Sets the number as the myuint value of the given a string
template <int T>
void myuint<T>::setNumber(std::string num)
{
    myuint<T>::number = num;
}

// Get the current myuint value
template <int T>
std::string myuint<T>::getNumber()
{
    return myuint<T>::number;
}

// Overloading the addition operator
template <int T>
myuint<T> myuint<T>::operator+(myuint<T> num)
{
    std::string firstNum = myuint<T>::number;
    std::string secondNum = num.getNumber();
    std::string resultString = "";

    int temp = 0;
    int num1_Size = firstNum.size() - 1;
    int num2_Size = secondNum.size() - 1;
    while (num1_Size >= 0 || num2_Size >= 0 || temp == 1)
    {
        temp += ((num1_Size >= 0) ? firstNum[num1_Size] - '0' : 0);
        temp += ((num2_Size >= 0) ? secondNum[num2_Size] - '0' : 0);
        resultString = char(temp % 2 + '0') + resultString;

        temp /= 2;
        num1_Size--;
        num2_Size--;
    }

    // If the result contains more bits than the size of the myuint, we truncate to fit it in T
    if (resultString.size() > T)
    {
        resultString = resultString.substr(resultString.size() - T, resultString.size());
    }

    myuint<T> resultMyuint;
    resultMyuint.setNumber(resultString);

    return resultMyuint;
}

// Overloading the subtraction operator
template <int T>
myuint<T> myuint<T>::operator-(myuint<T> num)
{
    // Setting the number we would subtract by (subtrahend)
    std::string subtrahend = num.getNumber();

    for (int i = 0; i < subtrahend.size(); i++)
    {
        subtrahend[i] == '0' ? (subtrahend[i] = '1') : (subtrahend[i] = '0');
    }

    num.setNumber(subtrahend);
    num += 1;

    return myuint<T>::operator+(num);
}

// Overloading the self addition operator
template <int T>
myuint<T> myuint<T>::operator+=(myuint<T> num)
{
    return *this = *this + num;
}

// Overloading the self subtraction operator
template <int T>
myuint<T> myuint<T>::operator-=(myuint<T> num)
{
    return *this = *this - num;
}

// Overloading the prefix addition operator
template <int T>
myuint<T> myuint<T>::operator++()
{
    return (*this += 1);
}

// Overloading the postfix addition operator
template <int T>
myuint<T> myuint<T>::operator++(int)
{
    *this += 1;
    return *this - 1;
}

// Overloading the prefix subtraction operator
template <int T>
myuint<T> myuint<T>::operator--()
{
    *this -= 1;
}

// Overloading the postfix subtraction operator
template <int T>
myuint<T> myuint<T>::operator--(int)
{
    *this -= 1;
    return *this + 1;
}

// Overloading the bitwise left shift operator
template <int T>
myuint<T> myuint<T>::operator<<(int num)
{
    std::string s = myuint<T>::number;
    for (int i = 0; i < num; i++)
    {
        s.erase(s.begin(), s.begin() + 1);
        s.append("0");
    }

    myuint<T> result;
    result.setNumber(s);
    return result;
}

// Overloading the bitwise right shift operator
template <int T>
myuint<T> myuint<T>::operator>>(int num)
{
    std::string s = myuint<T>::number;
    for (int i = 0; i < num; i++)
    {
        s.insert(0, "0");
    }

    // If the result contains more bits than the size of the myuint, we truncate to fit it in T
    s.erase(s.end() - num, s.end());

    myuint<T> result;
    result.setNumber(s);

    return result;
}

// Overloading the 'greater than' operator
template <int T>
bool myuint<T>::operator>(myuint<T> num)
{
    for (int i = 0; i < T; i++)
    {
        if (myuint<T>::number[i] != num.number[i])
        {
            if (myuint<T>::number[i] == '1')
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    return false;
}

// Overloading the 'less than' operator
template <int T>
bool myuint<T>::operator<(myuint<T> num)
{
    for (int i = 0; i < T; i++)
    {
        if (myuint<T>::number[i] != num.number[i])
        {
            if (myuint<T>::number[i] == '0')
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    return false;
}

// Overloading the 'equal to' operator
template <int T>
bool myuint<T>::operator==(myuint<T> num)
{
    for (int i = 0; i < T; i++)
    {
        if (myuint<T>::number[i] != num.number[i])
        {
            return false;
        }
    }
    return true;
}

// Overloading the 'less than or equal to' operator
template <int T>
bool myuint<T>::operator<=(myuint<T> num)
{
    return (*this < num || *this == num);
}

// Overloading the 'greater than or equal to' operator
template <int T>
bool myuint<T>::operator>=(myuint<T> num)
{
    return (*this > num || *this == num);
}

// Overloading the multiplication operator
template <int T>
myuint<T> myuint<T>::operator*(myuint<T> num)
{
    std::vector<myuint<T>> toAdd;
    std::string firstNum = myuint<T>::number;
    std::string secondNum = num.getNumber();

    std::string ans = "";
    for (int i = 0; i < T; i++)
    {
        for (int j = 0; j < T; j++)
        {
            if (firstNum[i] == '1' & secondNum[j] == '1')
            {
                ans += '1';
            }
            else
            {
                ans += '0';
            }
        }
        myuint<T> partAns;
        partAns.setNumber(ans);

        toAdd.push_back(partAns);
        ans = "";
    }

    myuint<T> answer(0);
    for (int i = 0; i < toAdd.size(); i++)
    {
        answer += toAdd.back() << i;
        toAdd.pop_back();
    }
    return answer;
}

// Overloading the division operator
template <int T>
myuint<T> myuint<T>::operator/(myuint<T> num)
{
    int i = 1;
    while ((*this -= num) >= num)
    {
        i++;
    }
    myuint<T> ans = (i);
    return ans;
}

// Overloading the modulus operator
template <int T>
myuint<T> myuint<T>::operator%(myuint<T> num)
{
    myuint<T> answer = *this;
    while ((answer -= num) >= num)
        ; // There is no need to store any values since we only care about the remainder

    return answer;
}

// Method to convert from a myuint to any specified number type
template <int T>
template <typename type>
type myuint<T>::convert_to()
{
    type result = 0;
    int n = 0;
    for (int i = T - 1; i >= 0; i--)
    {
        if (myuint::number[i] == '1')
        {
            result += pow(2, n);
        }
        n++;
    }
    return result;
}

int main()
{
    myuint<1024> a = (40000);
    std::cout << a.getNumber() << std::endl;
    std::cout << a.convert_to<int>() << std::endl;

    myuint<1024> b(3);
    std::cout << b.getNumber() << std::endl;
    std::cout << b.convert_to<int>() << std::endl;

    std::cout << ((a * b) / 2).convert_to<int>() << std::endl;
    return 0;
}