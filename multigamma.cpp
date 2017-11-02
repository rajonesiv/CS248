// computes gamma, the Euler-Mascharoni constant
#include<iostream>
#include<cmath>
#include "mpi.h"
using namespace std;
/*
thomas:$ module load openmpi-x86_64
thomas:$ mpicxx multihello.cpp
thomas:$ mpirun -np 5 a.out
*/

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
		for(int target=1; target<np; target=target+1)
		{
		  MPI_Send(&n,1,MPI_INT,target,
		    0,MPI_COMM_WORLD);
		}
	}
	else // id!=0
	{
		// get the message from 0
		MPI_Recv(&n,1,MPI_INT,0,0,
		  MPI_COMM_WORLD,&status);
	}
	
	b=n/np;
	int left=id*b+1;
	int right=(id+1)*b;
	
	double sum=0;
	for(int k=left; k<=right; k=k+1)
	{
		sum=sum+1.0/k;
	}
	
	cout << "id=" << id
	<< " left=" << left
	<< " right=" << right
	<< " sum=" << sum << endl;

	
	if(id>0)  // send our sum to proc. 0
	{
		MPI_Send(&sum,1,MPI_DOUBLE,0,
		    0,MPI_COMM_WORLD);
	}
	else // proc. 0
	{
		double bigsum=sum;
		for(int source=1; source<np; source=source+1)
		{
			MPI_Recv(&sum,1,MPI_DOUBLE,
			source,0,MPI_COMM_WORLD,&status);
			bigsum=bigsum+sum;
		}
		double gamma=bigsum-log(n);
		cout << "gamma="<<gamma<<endl;
	}
	
	MPI_Finalize();
	return 0;
}