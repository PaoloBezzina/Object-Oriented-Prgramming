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
    myuint<1024> a = (40000);
    std::cout << a.getNumber() << std::endl;
    std::cout << a.convert_to<int>() << std::endl;

    myuint<1024> b(3);
    std::cout << b.getNumber() << std::endl;
    std::cout << b.convert_to<int>() << std::endl;

    std::cout << ((a * b) / 2).convert_to<int>() << std::endl;
}

int test2()
{
    myuint<1024> i(5);                  // creates a 1024-bit unsigned int '5'
    myuint<2048> j = i << 1000 + 23;    // shifts it by 1000 bits and adds 23
    return j.template convert_to<int>() // returns 23
}