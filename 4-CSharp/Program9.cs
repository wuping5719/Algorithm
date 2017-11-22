using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace CSharpFun
{
    /// <summary>
    /// 序列化用法实例1
    /// </summary>
    /// @Author Nick
    /// @Time 2017-11-22
    class Program9
    {
        static void Main(string[] args)
        {
            // 序列化
            Person person = new Person();
            person.Name = "Myra";
            person.Age = 26;

            XmlSerializer myraSerializer = new XmlSerializer(typeof(Person));
            
            StreamWriter myraWriter = new StreamWriter("Person.xml");
            myraSerializer.Serialize(myraWriter, person);
            myraWriter.Close();

            // 反序列化
            Person myra = null;

            XmlSerializer myraDeserializer = new XmlSerializer(typeof(Person));

            FileStream fileStream = new FileStream("Person.xml", FileMode.Open);
            myra = (Person)myraDeserializer.Deserialize(fileStream);
            Console.WriteLine("My girlfriend is {0}, age is {1}.", myra.Name, myra.Age);
            fileStream.Close();
            
            Console.ReadKey();
        }
    }

    public class Person
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
    }
}
