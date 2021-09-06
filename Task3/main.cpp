#include <iostream>
#include "myuint.hpp"
void test();

int main()
{
    test();

    return 0;
}

void test()
{
    myuint<1024> i(5); // creates a 1024-bit unsigned int '5'
    std::cout << getNumberAsString(i);
}