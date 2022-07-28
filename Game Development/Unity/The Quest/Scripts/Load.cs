using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Load : MonoBehaviour
{



[SerializeField] GameObject player;
    
    void Start()
    {

    }

    
    void Update()
    {
        
    }
    private void OnEnable() {
        Debug.Log("enabled");
        Debug.Log(PlayerPrefs.GetFloat("Xposition"));

        Player.OnLoad += loadPosAndRot;
    }

    private void OnDisable() {
          Debug.Log("disabled");
        Debug.Log(PlayerPrefs.GetFloat("Xposition"));
         Player.OnLoad -= loadPosAndRot;
    }

    void loadPosAndRot(GameObject myPlayer){
        Debug.Log("load");
        
        player.GetComponent<Player>().loadLevel12();
        this.gameObject.SetActive(false);
    }

}
