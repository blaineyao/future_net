/*
 * main.cpp
 *
 *  Created on: 2016年3月25日
 *      Author: yaobin
 */
#include <iostream>

#include <set>

using namespace std;

int main()
{
	set<int> test;
	test.insert(1);
	test.insert(2);
	test.insert(1);
	for(int id:test)
		cout<<id<<endl;
	return 0;
}


