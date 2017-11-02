// computes gamma, the Euler-Mascharoni constant
// this version uses broadcast and reduce
#include<iostream>
#include<cmath>
#include "mpi.h"
using namespace std;

double dosum(int id, int np, int n)
{	
	double sum=0;
	for(int k=id+1; k<=n; k=k+np)
	{
		sum=sum+1.0/k;
	}
	
	cout << "id=" << id
	<< " sum=" << sum << endl;
	
	return sum;
}

int main(int argc, char *argv[])
{
	int n;
	int np,id,b;  // b is the block size
	MPI_Status status; 
	
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&id);
	MPI_Comm_size(MPI_COMM_WORLD,&np);
	
	if(id==0)
	{
		cout << "Please enter \"large\" n: ";
		cin >> n;	
	}
	MPI_Bcast(&n,1,MPI_INT,0,MPI_COMM_WORLD);
	
	double sum=dosum(id,np,n);
	
	double bigsum;
	
	MPI_Reduce(&sum,&bigsum,1,MPI_DOUBLE,
	  MPI_SUM,0,MPI_COMM_WORLD);
	
	if(id==0)
	{
		double gamma=bigsum-log(n);
		cout << "gamma="<<gamma<<endl;
	}
	
	MPI_Finalize();
	return 0;
}