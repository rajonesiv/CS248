// Sorting algorithms

public class Sorts
{
	private static int findmax(Comparable [] A, int end)
	{
		int maxpos=0;
		for(int i=1; i<=end; i++)
		{
			if(A[i].compareTo(A[maxpos])>0)
				maxpos=i;
		}
		return maxpos;
	}
	
	private static void swap(Object [] A, int x, int y)
	{
		Object tmp;
		tmp=A[x]; A[x]=A[y]; A[y]=tmp;
	}
	
	public static void select(Comparable [] A)
	{
		for(int end=A.length-1; end>0; end--)
		{
			int maxpos=findmax(A,end);
			swap(A,maxpos,end);
		}
	}
	
	public static void bubble(Comparable [] A)
	{
		boolean done=false;
		while(!done)
		{
			done=true;
			for(int i=0; i+1<A.length; i++)
			{
				if(A[i].compareTo(A[i+1])>0)
				{
					swap(A,i,i+1);
					done=false;
				}
			}
		}
	}
	
	public static void insertion(Comparable [] A)
	{
		for(int toinsert=1; toinsert<A.length; toinsert++)
		{
			Comparable item=A[toinsert];
			for(int i=toinsert-1; i>=0; i--)
			{
				if(A[i].compareTo(item)>0)
					A[i+1]=A[i];
				else
				{   A[i+1]=item; break; }
				if(i==0) A[0]=item;
			}
		}
	}
	
	public static void insertion(
	  Comparable [] A, int gap, int offset)
	{
		for(int toinsert=gap+offset; 
		    toinsert<A.length; toinsert+=gap)
		{
			Comparable item=A[toinsert];
			for(int i=toinsert-gap; i>=0; i-=gap)
			{
				if(A[i].compareTo(item)>0)
					A[i+gap]=A[i];
				else
				{   A[i+gap]=item; break; }
				if(i==offset) A[offset]=item;
			}
		}
	}
	
	public static void shell(Comparable [] A)
	{
		int gap=A.length/5;
		while(gap>1)
		{
			for(int offset=0; offset<gap; offset++)
				insertion(A,gap,offset);
			gap=(int)(gap/2.2);
		}
		insertion(A);
	}
	
	public static int partition(Comparable [] A,
	  int start, int stop)
	{
		int big=start;
		Comparable pivot=A[stop];
		for(int i=start; i<stop; i++)
		{
			if(A[i].compareTo(pivot)<=0)
			{
				swap(A,i,big);
				big++;
			}
		}
		swap(A,big,stop);
		return big;
	}
	
	public static void quick(Comparable [] A)
	{
		quickh(A,0,A.length-1);
	}
	
	private static void quickh(Comparable [] A,
	  int start, int stop)
	{
		// base cases
		if(stop<=start)  // size 0 or 1
		  return;
		if(start+1==stop) // size 2
		{
			if(A[start].compareTo(A[stop])>0)
				swap(A,start,stop);
			return;
		}
		// recursive case
		int pivot=partition(A,start,stop);
		quickh(A,start,pivot-1);
		quickh(A,pivot+1,stop);
	}
	
	public static void merge(Comparable [] A)
	{
		mergeh(A,0,A.length-1);
	}
	
	private static void mergeh(
	  Comparable [] A, int start, int stop)
	{
		// base cases
		if(stop<=start)  // size 0 or 1
		  return;
		if(start+1==stop) // size 2
		{
			if(A[start].compareTo(A[stop])>0)
				swap(A,start,stop);
			return;
		}
		// recursive case
		int mid=(start+stop)/2;
		mergeh(A,start,mid);
		mergeh(A,mid+1,stop);
		// merge!
		domerge(A,start,mid,stop);
	}
	
	public static void selection(Comparable [] A)
	{
		for(int i=A.length-1; i>0; i--)
		{
			int maxpos=findmax(A,i);
			swap(A,maxpos,i);
		}
	}
	
	private static void domerge(Comparable [] A,
	  int start, int mid, int stop)
	{
		Comparable [] B=new Comparable[stop-start+1];
		int left=start;
		int right=mid+1;
		for(int i=0; i<B.length; i++)
		{
			// when do we pull from the left?
			if(right>stop || left<=mid && 
				A[left].compareTo(A[right])<=0)
				{ B[i]=A[left]; left++; }
			else
				{ B[i]=A[right]; right++; }
		}
		for(int i=0; i<B.length; i++)
			A[start+i]=B[i];
	}
}



