using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// Stack 用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program1
    {
        static void Main(string[] args)
        {
            Stack<string> numbers = new Stack<string>();
            numbers.Push("One");
            numbers.Push("Two");
            numbers.Push("Three");
            numbers.Push("Four");
            numbers.Push("Five");
            numbers.Push("Six");

            foreach (string number in numbers)
            {
                Console.WriteLine(number);
            }

            Console.WriteLine();
            Console.WriteLine("Popping '{0}'", numbers.Pop());
            Console.WriteLine("Peek at next item to destack: {0} ", numbers.Peek());
            Console.WriteLine("Popping '{0}'", numbers.Pop());
            Console.ReadLine();
        }
    }
}
