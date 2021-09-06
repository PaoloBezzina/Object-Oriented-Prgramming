#include <iostream>
#include <string>
#include <math.h>

std::string getNumberAsString(int n);

template <int T>
class myuint
{

private:
    std::string number;

public:
    myuint(int num);
    myuint();
    std::string getNumber();
    void setNumber(std::string num);

    myuint<T> operator + (myuint<T> num);
    myuint<T> operator - (myuint<T> num);
    myuint<T> operator -= (myuint<T> num);
    myuint<T> operator += (myuint<T> num);

    myuint<T> operator ++ ();
    myuint<T> operator ++ (int);
    myuint<T> operator -- ();
    myuint<T> operator -- (int);
};