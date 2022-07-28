using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using UnityEngine.Audio;

public class MainMenu : MonoBehaviour
{

    [SerializeField] AudioMixer audioMixer;

    [SerializeField] GameObject HowToMenu;

        [SerializeField] GameObject mainMenu;
        [SerializeField] GameObject settingsMenu;

    // Start is called before the first frame update


    public void SetVolume(float volume) {
        audioMixer.SetFloat("volume",volume);
    }
    void Start()
    {
        
    }


public void howToMenu(){
    mainMenu.SetActive(false);
    HowToMenu.SetActive(true);
}


public void SettingsMenu(){
        mainMenu.SetActive(false);
        settingsMenu.SetActive(true);

}

public void quit(){
    Application.Quit();
}


public void SettingsBackToMenu(){
    settingsMenu.SetActive(false);
    mainMenu.SetActive(true);
}

public void loadNewGame(){
        SceneManager.LoadScene("level1");
}


    // Update is called once per frame
    void Update()
    {
        
    }
}
