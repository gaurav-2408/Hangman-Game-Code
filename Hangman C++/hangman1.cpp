/*Author:Gaurav.R.Jain
  Fully Created on:2 April 2020*/
#include <bits/stdc++.h>
using namespace std;

set<char>us;

string arr[]={"sleep","skin","fairly","statement","season","what"	//repository of words
"forgot","one","square","sink","ahead","selection"
"today","cross","close","sang","neighborhood","union",
"if","lovely","park","fell","voice","change"
"usually","enough","escape","build","ice","trail"
"stiff","layers","piano","location","think","different"
"closely","cutting","cream","alive","far","yourself","mobile"};

int chooseRandom(int s=0,int e=43,int count=1)
{
	int i; 
    for (i = 0; i < count; i++) 
	{ 
        int num = (rand() % (e - s + 1)) + s; 
        return num; 
    } 
}

int main()
{
	srand(time(0));
	int randval;
	int val,val1,counter=0,n,count=0,t=-1;
	randval=chooseRandom(0,43,1);
	string s;
	s=arr[randval];
	int i,j;
	char ch;
	int arr[26];
	for(i=0;i<26;i++)
	{
		arr[i]=0;
	}
	for(i=0;i<s.length();i++)
	{
		val=s[i]-97;
		arr[val]++;
	}
	for(i=0;i<26;i++)
	{
		if(arr[i]==0)
		arr[i]--;
	}
	n=s.length();
	char visited[n];
	char visited1[n];
	for(i=0;i<n;i++)
	{
		visited[i]=false;
		visited1[i]=false;
		us.insert(s[i]);
	}
		
	cout<<"The word consists of "<<s.length()<<" characters"<<endl;
	while(counter!=8)
	{
		cout<<"\n";
		cin>>ch;
		val1=ch-97;
		if(arr[val1]==-1)
		{
			//arr[val1]--;
			cout<<"incorrect guess"<<endl;
			++counter;
			cout<<"now you have "<<8-counter<<" chances"<<endl;
			for(j=0;j<n;j++)
			{
					if(visited[j])
					cout<<visited[j]<<" ";
					else
					cout<<"_"<<" ";
			}
		}
		else
		{
			if(arr[val1]>0)
			{
				count++;
				arr[val1]--;
				cout<<"correct guess"<<endl;
				for(i=0;i<s.length();i++)
				{
					
					if(ch==s[i])
					{
						t++;
						visited[i]=ch;
					}
				}
				for(j=0;j<n;j++)
				{
					if(visited[j])
					cout<<visited[j]<<" ";
					else
					cout<<"_"<<" ";
				}
			}
			else
			{
				cout<<"incorrect guess"<<endl;
				++counter;
				cout<<"now you have "<<8-counter<<" chances"<<endl;
				for(j=0;j<n;j++)
				{
					if(visited[j])
					cout<<visited[j]<<" ";
					else
					cout<<"_"<<" ";
				}
			}
			//counter++;
		}
		if(count==s.length()||count==us.size())
		{
			cout<<"\nvola!!you guesssed the word correctly!!"<<endl;
			cout<<"The word is "<<s;
			break;
		}
		if(counter==8)
		{
			cout<<"you failed"<<endl;
			cout<<"The correct word was "<<s<<endl;
		}
	}
	return 0;
}
