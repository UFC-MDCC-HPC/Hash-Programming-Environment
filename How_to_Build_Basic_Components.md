# Introduction #

This tutorial aims to teach how to build some basic components. It assume that you already knows some basic stuff like build, register and deploy a component and how to rename or edit a code of a unit's interface.
Here we will show how to build four components:
  * HelloWorld
  * AllToAll
  * PI
  * PIWithFarm


# Components #

## Hello World ##

This program just writes "HelloWorld" in the output console.

First create an abstract component which you will call HelloWorld. Create an unit inside this component and name it Print and then right-click the unit and click "create interface". Name the interface PrintInterface and then save. Right-click the interface and click in "edit source" and then save the .hpe. Now you can build, register and deploy the component (right in this order).

Now create a concrete component which you will call HelloWorldImpl. Drag the component HelloWorld from your repository and right-click it and choose "implements" so that we can use the unit Print from the HelloWorld component. Right-click the unit Print and choose "show interface" and name the interface PrintInterfaceImpl. Create a code for that interface and then in the file PrintInterfaceImpl.cs edit the method compute() putting the following line:

```
Console.WriteLine("HelloWorld");
```

Save the code, save the .hpe and then you can build, register and deploy the component.


## All To All ##

This program makes N units to send a number to each other.

In order to build the component just like in this tutorial, you will need the component MPIDirect. You can find it <here(link)>.

Create an abstract component that you will call AllToAll. Now create an unit and name it AllToAll. Considering that you have the MPIDirect component, drag it from your repository to your work area. Click in "Connections" (above the configuration elements), click in the orange square inside the MPIDirect component ant then click the unit that you just created. Right-click the unit and click "create interface". Name the interface IAllToAll, right-click the interface and click in "edit source" and then save the .hpe. Now you can save, build, register and deploy the component.

Create a concrete component and name it AllToAllImpl. Drag from your repository the component AllToAll and right-click it and choose "implements". Right-click the unit AllToAll`[N]` and choose "show interface" and name the interface IAllToAllImpl. Create a code for that interface and then in the file IAllToAllImpl.cs edit the method compute() putting the following lines:

```
Intracommunicator worldcomm = Communicator.world;
int rank = worldcomm.Rank;
int size = worldcomm.Size;
int []numRandSent = new int[size];
int []numRandResult = new int[size];
Random random = new Random();
int num = random.Next(1000);
for(int i=0;i<size;i++)
	numRandSent[i]=num;
numRandResult=worldcomm.Alltoall<int>(numRandSent);
for(int i=0;i<size;i++){
	if (i!=rank)
		Console.WriteLine("Process of rank " + i + " send the number " + numRandResult[i]);
	else
		Console.WriteLine("My Rank is "+rank+" and my number is "+numRandSent[i]);
}
mpi.MPI.Dispose();
```

Don't forget to add the MPI library with the line:

```
using MPI;
```

Now add a reference of your MPI.dll library to your interace by right-clicking the interface and choosing "Add Reference". Once you done that you can save the code, save the .hpe and then you can build, register and deploy the component.


## PI ##

This program makes N units to calculate the value of PI.

The way to build this component is much like the way to build the AllToAll component.

In order to build the component just like in this tutorial, you will need the component MPIDirect. You can find it <here(link)>.

Create an abstract component that you will call !PI. Now create an unit and name it !PI. Considering that you have the MPIDirect component, drag it from your repository to your work area. Click in "Connections" (above the configuration elements), click in the orange square inside the MPIDirect component ant then click the unit that you just created. Right-click the unit and click "create interface". Name the interface IPI, right-click the interface and click in "edit source" and then save the .hpe. Now you can save, build, register and deploy the component.

Create a concrete component and name it !PIImpl. Drag from your repository the component !PI and right-click it and choose "implements". Right-click the unit PI`[N]` and choose "show interface" and name the interface IPIImpl. Create a code for that interface and then in the file IPIImpl.cs edit the method compute() putting the following lines:

```
double	homepi,         /* value of pi calculated by current task */
pisum,	        /* sum of tasks pi values */
pi,	        /* average of pi after "darts" is thrown */
avepi;	        /* average pi value for all iterations */

int	taskid,	        /* task ID - also used as seed number */
numtasks,       /* number of tasks */
i;

Intracommunicator worldcomm = Communicator.world;
taskid = worldcomm.Rank;
numtasks = worldcomm.Size;
    
Console.WriteLine ("MPI task " + taskid + " has started...");

if (taskid == MASTER) 
   Console.WriteLine ("Using " + numtasks + " tasks to compute pi (3.1415926535)");

/* Set seed for random number generator equal to task ID */
random = new Random(taskid);

avepi = 0;
for (i = 0; i < ROUNDS; i++) {
   /* All tasks calculate pi using dartboard algorithm */
   homepi = dboard(DARTS);
   
   /* Use MPI_Reduce to sum values of homepi across all tasks 
    * Master will store the accumulated value in pisum 
    * - homepi is the send buffer
    * - pisum is the receive buffer (used by the receiving task only)
    * - the size of the message is sizeof(double)
    * - MASTER is the task that will receive the result of the reduction
    *   operation
    * - MPI_SUM is a pre-defined reduction function (double-precision
    *   floating-point vector addition).  Must be declared extern.
    * - MPI_COMM_WORLD is the group of tasks that will participate.
    */

   pisum = worldcomm.Reduce<double>(homepi, Operation<double>.Add, MASTER);

   /* Master computes average for this iteration and all iterations */
   if (taskid == MASTER) {
      pi = pisum/numtasks;
      avepi = ((avepi * i) + pi)/(i + 1); 
      Console.WriteLine("   After " + (DARTS * (i + 1)) + " throws, average value of pi = "+ avepi);
   }    
}
```

And add the following method which is called from compute():

```
private double dboard(int darts){
  double x_coord, y_coord, pi, r; 
  int score, n;
  score = 0;

  /* "throw darts at board" */
  for (n = 1; n <= darts; n++)  {
    /* generate random numbers for x and y coordinates */
    r = (double)random.NextDouble()/*/cconst*/;
    x_coord = r; 
    r = (double)random.NextDouble();
    y_coord = r; 
	
    /* if dart lands in circle, increment score */
    if ((x_coord * x_coord + y_coord * y_coord) <= 1.0)
         score++;
  }
	
  /* calculate pi */
  pi = 4.0 * (double)score/(double)darts;
  return pi;
} 
```

Don't forget to add the MPI library with the line:

```
using MPI;
```

Now add a reference of your MPI.dll library to your interace by right-clicking the interface and choosing "Add Reference". Once you done that you can save the code, save the .hpe and then you can build, register and deploy the component.