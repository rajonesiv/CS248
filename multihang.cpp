// this hangs
#include<iostream>
#include<cmath>
#include "mpi.h"
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int np,id;  
	MPI_Status status; 
	
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&id);
	MPI_Comm_size(MPI_COMM_WORLD,&np);
	
	int partner;
	// figure out who we are
	if(id%2==0) // even
	{
		partner=id+1;
	}
	else
	{
		partner=id-1;
	}
	
	n=42;
	MPI_Recv(&n,1,MPI_INT,partner,0,
		  MPI_COMM_WORLD,&status);
	
	MPI_Send(&n,1,MPI_INT,partner,
		    0,MPI_COMM_WORLD);
			
	cout << "Done!\n";

	MPI_Finalize();
	return 0;
}