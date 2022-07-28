using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Audio;

public class GameManager : MonoBehaviour
{

    [SerializeField] AudioSource AudioSource;
    [SerializeField] AudioClip AudioClip;
    [SerializeField] AudioMixerGroup group;

    public static GameManager instance;

    private void Awake() {
        if(instance !=null){
            Destroy(this);
        } 

        else {
            DontDestroyOnLoad(this.gameObject);
            instance=this;
        }
    }
    
    void Start()
    {

        AudioSource.PlayOneShot(AudioClip);
    }

    
    void Update()
    {
        
    }
}
