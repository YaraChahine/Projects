using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using UnityEngine.SceneManagement;

public  class Player : MonoBehaviour
{
    [SerializeField]
    int playerHealth = 200;

    [SerializeField] GameObject allCrystalsCollected;
    int counterCrystalSuccess=0;
    [SerializeField]
    int crystalScore = 0;

    [SerializeField]
    Slider healthBar;
    [SerializeField]
    Gradient gradient;

    [SerializeField]
    Image fillBar;

    [SerializeField]
    Slider crystalBar;
    [SerializeField]
    Gradient crystalGradient;
    [SerializeField]
    Image fillBarCrystals;
    
    [SerializeField] AudioClip audio1;
    [SerializeField] AudioClip audio2;
    [SerializeField] GameObject UIdied;

    [SerializeField] TMP_Text textScore;
    [SerializeField] GameObject crystalImage;
    [SerializeField] AudioSource audioSrc;
   
    private void Awake() {
          Cursor.lockState = CursorLockMode.None;
            Cursor.visible = true;
   }
    void Start()
    {
   Cursor.lockState = CursorLockMode.None;
            Cursor.visible = true;
        audioSrc= GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }



    private void OnCollisionEnter(Collision other) {
        if(other.gameObject.tag == "Enemy"){
            playerHealth-=25;
     //       healthText.text = $"Health: {playerHealth}";
            healthBar.value = playerHealth;
            fillBar.color = gradient.Evaluate(healthBar.normalizedValue);
        } if(playerHealth==0){
            Destroy(this.gameObject);
           // textScore.SetText("You died! Your score is : " scor)
            UIdied.SetActive(true);
        }if(other.gameObject.tag == "Crystal"){
            audioSrc.PlayOneShot(audio1);
            crystalScore++;
            crystalBar.value = crystalScore;
            fillBarCrystals.color = crystalGradient.Evaluate(crystalBar.normalizedValue);
            if (crystalScore==12)
            {
                StartCoroutine("appear");
                allCrystalsCollected.SetActive(false);
            }
            Destroy(other.gameObject);
        }
         if(other.gameObject.tag == "Medkit" && playerHealth<100){
                         audioSrc.PlayOneShot(audio2);

            Destroy(other.gameObject);
            playerHealth+=25;
            healthBar.value = playerHealth;
            fillBar.color = gradient.Evaluate(healthBar.normalizedValue);
        }if(other.gameObject.tag == "ArrowsBox"){
            audioSrc.PlayOneShot(audio2);
            Destroy(other.gameObject);
            Shooting.arrows+=10;
        }if(other.gameObject.tag == "MagicBallsBox"){
            audioSrc.PlayOneShot(audio2);
            Destroy(other.gameObject);
            Shooting.magicBalls+=10;
        }
    }

    private void OnTriggerEnter(Collider other) {
        if(other.gameObject.tag == "Medkit" && playerHealth<100){
            Destroy(other.gameObject);
                        audioSrc.PlayOneShot(audio2);

            playerHealth+=25;
            healthBar.value = playerHealth;
            fillBar.color = gradient.Evaluate(healthBar.normalizedValue);
        }if(other.gameObject.tag == "ArrowsBox"){
                        audioSrc.PlayOneShot(audio2);

            Destroy(other.gameObject);
            Shooting.arrows+=10;
        }if(other.gameObject.tag == "MagicBallsBox"){
            Destroy(other.gameObject);
                        audioSrc.PlayOneShot(audio2);

            Shooting.magicBalls+=10;
        }
    }


     IEnumerator appear(){
         crystalImage.SetActive(true);
         yield return new WaitForSeconds(2);
         crystalImage.SetActive(false);
     }
    }
