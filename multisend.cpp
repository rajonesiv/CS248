#include<iostream>
#include "mpi.h"
using namespace std;
/*
thomas:$ module load openmpi-x86_64
thomas:$ mpicxx multihello.cpp
thomas:$ mpirun -np 5 a.out
*/

int main(int argc, char *argv[])
{
	MPI_Init(&argc,&argv);
	
	int id; // process name
	MPI_Comm_rank(MPI_COMM_WORLD,&id);
	
	int np; // total processes running
	MPI_Comm_size(MPI_COMM_WORLD,&np);
	
	int n;
	if(id==0)
	{
		cout << "Please enter a number:";
		cin >> n;
		for(int target=1; target<np; target=target+1)
		{
		  MPI_Send(&n,1,MPI_INT,target,
		    0,MPI_COMM_WORLD);
		}
	}
	else // id!=0
	{
		MPI_Status status; // we ignore this but need it
		// get the message from 0
		MPI_Recv(&n,1,MPI_INT,0,0,
		  MPI_COMM_WORLD,&status);
		  
		cout << id << " of "<< np << " Hello! "
		  << "I got n=" << n << endl;
		  
		// infinite loop!
		while (true) { ;}
	}
	
	MPI_Finalize();
	return 0;
}