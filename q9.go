/*
 * by:
 *      Amir Hossein Sana
 *      Mohammad Mahdi Malmasi
 *      Mohammad Fatemi
 */


 


package main

import (
    "fmt"
    )
    
    
    
func main() {
    
    var numberOfVs int
    fmt.Scanf("%d", &numberOfVs)

    
	var vs[100002] int
	var holdToRead int
    for v := 0; v < numberOfVs; v++ {
	   fmt.Scanf("%d", &holdToRead)
	   vs[holdToRead]++;
    }
    
    
    output := 0
    for i := 1; i <= 100000; i++ {
		output += vs[i] * (vs[i-1] + vs[i+1])
    }
    
    
    fmt.Printf("%d\n", output/2)
}

