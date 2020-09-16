/*
 * by: 
 *    Amir Hossein Sana
 *    Mohammad Fatemi
 *    Saman Hosseini
 *    Mohammad Mahdi Malmasi
 */


package main

import (
"fmt"
  "sort"
)

var mp = make(map[int]int)

func main() {
  var n, m int
  fmt.Scanf("%d %d", &n, &m)

  if n < m {
    solve(n, m)
  } else {
    solve(m, n)
  }

  keys := make([]int, len(mp))
  for key := range mp{
    keys = append(keys, key)
  }

  sort.Ints(keys)

  for _, key := range keys {
    if mp[key] == 0 {
      continue
    }
    tkey := key * -1
    fmt.Printf("%d %d*%d tiles\n", mp[key], tkey, tkey)
  }
}

func solve(n, m int) {
  if n == 0 {
    return
  }
  k := 1
  for 2*k <= n {
    k *= 2
  }
  mp[-k] += m / k
  solve(n-k, m)
  solve(m%k, k)
}