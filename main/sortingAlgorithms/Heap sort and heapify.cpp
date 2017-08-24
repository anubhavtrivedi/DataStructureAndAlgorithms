#include <iostream>
/*
*Algorithm complexity O(nlg(n))
*input :
*change the value of 'n' to sort more numbers other than 10
* x x x x x x x ... x		n elements to be sorted	
* for execution:
* 1. go to any onlie ide like:
*    -http://ide.geeksforgeeks.org/index.php
* 2. paste the code into the editor
* 3. set custom input as:
*		 45 34 7 33 4 7 3 6 3 999
*/
using namespace std;
void heapify(int k);
void print();
int a[11];
int n=10;
int main() {
	int i=0;
	for(i=1;i<11;i++){
	   cin >>a[i];
	}
	int temp;

	// Building heap

	for(i=5; i>0; i--){
	    heapify(i);
	}
    //sorting elements

	for(i=1; i<11;i++){
heapify(1);
 temp=a[1];
    a[1]=a[n];
    a[n]=temp;
    n--;
	}
 print();
	
	return 0;
}
// the heapify function has the complexity of O(log(n)) 
void heapify(int k){
    int temp;
    if(2*k>n)
    return;
    if(2*k +1 >n){
        if(a[k]<a[2*k])
        {  temp=a[2*k ];
            a[2*k]=a[k];
            a[k]=temp;
         
            
        }   return;
    }
    
    if(a[k]<a[2*k]||a[k]<a[2*k +1]){
        if(a[2*k]<a[2*k +1])
        {
            temp=a[2*k + 1];
            a[2*k+1]=a[k];
            a[k]=temp;
            heapify(2*k +1);
        }
        else{
            temp=a[2*k];
            a[2*k]=a[k];
            a[k]=temp;
            heapify(2*k);
        }
        
    }
}
void print (){
    int i;
    	for(i=1;i<11;i++){
	    cout<<" "<<a[i];
	}
}
