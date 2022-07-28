using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PauseScript : MonoBehaviour
{
    // Start is called before the first frame update


[SerializeField] GameObject pauseMenu;






private void Awake() {

}

    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    
    public  void Pause(){

        Time.timeScale = 0;
        pauseMenu.SetActive(true);

    }


    public void Resume(){
              Time.timeScale = 1;
        pauseMenu.SetActive(false);
    }

    public void Quit(){
                Application.Quit(); 

    }
}
