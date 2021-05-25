using Forest;
using System;

var values = new int[] { 4, 8, 2, 9, 6, 7, 1 };
BSTree<int> tree = new(values[0]);
tree.AppendRange(values[1..]);

Console.WriteLine($"- Sorted Tree: {tree.ToString()}");
Console.WriteLine($"- Nodes count: {tree.CountNodes()} [Expected: {values.Length}]");
Console.WriteLine($"- Leaves count: {tree.CountLeaves()}");


/*
			OUTPUT:

- Sorted Tree: 1 2 4 6 7 8 9
- Nodes count: 7 [Expected: 7]
- Leaves count: 3

 */
