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
	
	cout << id << " of "<< np << " Hello!\n";
	
	MPI_Finalize();
	return 0;
}