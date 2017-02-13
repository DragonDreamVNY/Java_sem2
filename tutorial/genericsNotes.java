//generics notes


// public int add(int x, int y){
//   return x + y;
// }
//
// int n1 = 4;
// int n2 = 5;
// int n3 = add(4,8);
//
// double n4 = 4.5;
// double n5 = 5.5;
// double n6 = add(4.5,5.5);

//example 1:
public <Thingy> add(<Thingy> a, <Thingy> b){
  return a+b;
}
// at compile time, as long as two arguments have same type, it returns the type of the first param
int n1 = 4;
int n2 = 5;
int n3 = add(4,8);

double n4 = 4.5;
double n5 = 5.5;
double n6 = add(4.5,5.5);

//example 2:
public <T1> add(<T1> a, <T2> b){
  return a + (<T1>)b; //cast type into second.
}
// at compile time, as long as two arguments have same type, it returns the type of the first param
int n1 = 4;
int n2 = 5;
int n3 = add(4,8);

double n4 = 4.5;
double n5 = 5.5;
double n6 = add(4.5,5.5);

result = add(n1, n4); //result will be an int type which is the type of the fist argument

class ArrayList<T>{
  T[]
}


//example 3: pseudo code
Class hashmap <key , value>

hashmap <String,int> map =

  map.getKeys();
  map.getValue();
