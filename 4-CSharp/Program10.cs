using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;

namespace CSharpFun
{
    /// <summary>
    /// 序列化用法实例2 — 基本序列化
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-22
    class Program10
    {
        static void Main(string[] args)
        {
            LoveGirl girl = new LoveGirl();
            girl.Name = "Myra";
            girl.Age = 26;
            girl.Country = "New Zealand";

            IFormatter formatter = new BinaryFormatter();

            Stream streamIn = new FileStream("LoveFile.bin", 
                FileMode.Create, FileAccess.Write, FileShare.None);
            formatter.Serialize(streamIn, girl);
            streamIn.Close();

            Stream streamOut = new FileStream("LoveFile.bin",
                FileMode.Open, FileAccess.Read, FileShare.Read);
            LoveGirl myLove = (LoveGirl) formatter.Deserialize(streamOut);
            streamOut.Close();

            Console.WriteLine("My girlfriend is {0}, comes from {1}, age is {2}.", 
                myLove.Name, myLove.Country, myLove.Age);

            Console.ReadKey();
        }
    }

    [Serializable]
    public class LoveGirl
    {
        private string name;

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        private int age;

        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        private string country;

        public string Country
        {
            get { return country; }
            set { country = value; }
        }
    }
}
