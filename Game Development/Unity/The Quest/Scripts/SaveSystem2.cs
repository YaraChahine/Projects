
using UnityEngine;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;


public static class SaveSystem2 {


public static void SaveLevel2(Player player){
    BinaryFormatter formatter= new BinaryFormatter();
    string path= Application.persistentDataPath + "/level2.fun";
    FileStream stream = new FileStream(path,FileMode.Create);




    Level2Data data= new Level2Data(player);
    formatter.Serialize(stream,data);
    stream.Close();



}


public static Level2Data LoadLevel2(){
    string path= Application.persistentDataPath + "/level2.fun";
    if (File.Exists(path)){
     
     BinaryFormatter formatter= new BinaryFormatter();
     FileStream stream= new FileStream(path,FileMode.Open);
     Level2Data data= formatter.Deserialize(stream) as Level2Data;
    stream.Close();

    return data;
    
    }


       else{
            Debug.LogError("Save file not found in"+ path);
            return null;
        }
}


}