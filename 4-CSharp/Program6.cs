using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// 泛型用法实例
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-21
    class Program6
    {
        static void Main(string[] args)
        {
            // 声明一个整型数组
            MyraGenericArray<int> intArray = new MyraGenericArray<int>(5);

            // 设置值
            for(int i=0; i<5; i++)
            {
                intArray.setItem(i, i*10);
            }

            // 获取值
            for (int i=0; i<5; i++)
            {
                Console.Write(intArray.getItem(i) + " ");
            }
            Console.WriteLine();

            // 声明一个字符数组
            MyraGenericArray<char> charArray = new MyraGenericArray<char>(5);

            // 设置值
            for (int c=0; c<5; c++)
            {
                charArray.setItem(c, (char)(c + 97));
            }

            // 获取值
            for (int c=0; c<5; c++)
            {
                Console.Write(charArray.getItem(c) + " ");
            }
            Console.WriteLine();
            Console.ReadKey();
        }
    }

    public class MyraGenericArray<T>
    {
        private T[] array;

        public MyraGenericArray(int size)
        {
            array = new T[size + 1];
        }

        public T getItem(int index)
        {
            return array[index];
        }

        public void setItem(int index, T value)
        {
            array[index] = value;
        }
    }
}
