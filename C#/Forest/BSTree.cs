using System;
using System.Collections.Generic;
using System.Text;

namespace Forest {
    public class BSTree<T> where T : IComparable<T> {
        public T Value { get; set; }
        public BSTree<T> Right { get; private set; }
        public BSTree<T> Left { get; private set; }

        public BSTree(T value)
            => Value = value;

        public void Append(T value) {
            if(value.CompareTo(Value) <= 0) {
                if(Left is null) {
                    Left = new(value);
                } else {
                    Left.Append(value);
                }
            }else if(Right is null) {
                Right = new(value);
            }else {
                Right.Append(value);
            }
        }

        public void AppendRange(IEnumerable<T> values) {
            foreach(T value in values) {
                Append(value);
            }
        }

        new public string ToString() {
            StringBuilder str = new();
            if(Left is not null) {
                str.Append(Left.ToString());
            }
            str.Append($"{Value} ");
            if(Right is not null) {
                str.Append(Right.ToString());
            }
            return str.ToString();
        }

        public int CountNodes() {
            int count = 1;
            if(Left is not null) {
                count += Left.CountNodes();
            }
            if(Right is not null) {
                count += Right.CountNodes();
            }
            return count;
        }

        public int CountNodesButItsOneLine()
            => 1 + (Left?.CountNodesButItsOneLine() ?? 0) + (Right?.CountNodesButItsOneLine() ?? 0);

        public int CountLeaves() {
            int count = 0;
            if(Left is not null) {
                count += Left.CountLeaves();
            }
            if(Right is not null) {
                count += Right.CountLeaves();
            }
            if(count == 0)
                count++;
            return count;
        }
    }
}
