using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Weapons : MonoBehaviour
{
    [SerializeField]

    GameObject wand;

    [SerializeField]

    GameObject bow;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {

        
        if(Input.GetKeyDown(KeyCode.T)){
            wand.SetActive(true);
            bow.SetActive(false);
        }
        if(Input.GetKeyDown(KeyCode.Y)){
            wand.SetActive(false);
            bow.SetActive(true);
        }
    }


}