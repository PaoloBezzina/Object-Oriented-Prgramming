#include <iostream>
/* #include <string>
#include <math.h> */

std::string decimalToBinary(int n);

template <int T>
class myuint
{

private:
    std::string number;

public:
    myuint();
    myuint(int num);
    std::string getNumber();
    void setNumber(std::string num);

    myuint<T> operator+(myuint<T> num);
    myuint<T> operator-(myuint<T> num);
    myuint<T> operator+=(myuint<T> num);
    myuint<T> operator-=(myuint<T> num);

    myuint<T> operator++();
    myuint<T> operator++(int);
    myuint<T> operator--();
    myuint<T> operator--(int);

    myuint<T> operator<<(int num);
    myuint<T> operator>>(int num);
    myuint<T> operator*(myuint<T> num);
    myuint<T> operator/(myuint<T> num);
    myuint<T> operator%(myuint<T> num);

    bool operator>(myuint<T> num);
    bool operator<(myuint<T> num);
    bool operator==(myuint<T> num);
    bool operator<=(myuint<T> num);
    bool operator>=(myuint<T> num);

    template <typename type>
    type convert_to();
};