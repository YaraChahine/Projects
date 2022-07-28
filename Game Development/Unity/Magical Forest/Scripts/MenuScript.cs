using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MenuScript : MonoBehaviour
{


      [SerializeField] GameObject Menu;
    // Start is called before the first frame update

    public void ButtonClicked(){

        if (Menu.activeSelf==false){
        Menu.SetActive(true);
        }
        else
        {
        Menu.SetActive(false);
 
        }
    }


    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
