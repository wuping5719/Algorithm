using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// LINQ进阶实例: orderby 排序, group 分组，from 复合查询，join 联接
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-22
    class Program11
    {
        static void Main(string[] args)
        {
            // 用 orderby 子句进行排序
            int[] array = { 1, 6, 9, 12, 98, 62, 36, 108 };
            var query1 = from a1 in array 
                         orderby a1 
                         select a1;
            foreach(var q1 in query1)
            {
                Console.Write("{0} ", q1);
            }
            Console.WriteLine();
            Console.WriteLine();

            var query2 = from a2 in array 
                         orderby a2 descending 
                         select a2;
            foreach (var q2 in query2)
            {
                Console.Write("{0} ", q2);
            }
            Console.WriteLine();

            // 用 group 子句进行分组
            Student[] students = {
               new Student("Myra", '女', 26),
               new Student("Nick", '男', 27),
               new Student("Tom", '男', 18),
               new Student("Marry", '女', 16),
               new Student("Alice", '女', 22),
               new Student("Bob", '男', 20)
            };
            Console.WriteLine();

            var query3 = from st in students
                         group st by st.Sex;
            foreach (var st in query3)
            {
                Console.WriteLine(st.Key);
                foreach (var s in st)
                {
                    Console.WriteLine("Name: {0}", s.Name);
                }
            }
            Console.WriteLine();

            // 分组后排序
            var query4 = from st in students
                         group st by st.Age into stGrp
                         orderby stGrp.Key descending
                         select stGrp;
            foreach (var st in query4)   // 外层遍历学生年龄
            {
                Console.Write("{0}岁的学生：", st.Key);
                foreach (var s in st)   // 内层遍历学生信息
                {
                    Console.Write(s.Name + " " + s.Sex);
                    Console.WriteLine();
                }
            }
            Console.WriteLine();

            // 用 from 子句进行复合查询
            int[] intArray1 = { 5, 15, 25, 35, 45, 55, 65};
            int[] intArray2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
            var query5 = from v1 in intArray1
                         from v2 in intArray2
                         where v2 % v1 == 0
                         group v2 by v1;
            foreach (var grp in query5)   
            {
                Console.WriteLine("分组的标准: {0}", grp.Key);
                foreach (var val in grp) 
                {
                    Console.Write(val + " ");
                }
                Console.WriteLine();
            }
            Console.WriteLine();

            // 用 join 子句进行分组连接
            var query6 = from v1 in intArray1
                         join v2 in intArray2 on v1 % 5 equals v2 % 15 into v2Grp
                         select new { Val1 = v1, Val2Grp = v2Grp };
            foreach (var obj in query6)
            {
                Console.WriteLine("{0}: ", obj.Val1);
                foreach (var val in obj.Val2Grp)
                {
                    Console.Write("{0} ", val);
                }
                Console.WriteLine();
            }
            Console.WriteLine();

            Console.WriteLine("Max of intArray1: {0}", intArray1.Max());
            Console.WriteLine("Min of intArray1: {0}", intArray1.Min());
            Console.WriteLine("Average of intArray1: {0}", intArray1.Average());
            Console.WriteLine("Sum of intArray1: {0}", intArray1.Sum());

            Console.ReadKey();
        }
    }

    public class Student
    {
        private string name;

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        private char sex;

        public char Sex
        {
            get { return sex; }
            set { sex = value; }
        }

        private int age;

        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        public Student(string name, char sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }
}
