using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Story : MonoBehaviour
{




    [SerializeField] TMP_Text storyText;
    [SerializeField] Image mainImage;
    [SerializeField] Image largeimage1;
    [SerializeField] Image largeimage2;
    [SerializeField] Image image2;
    [SerializeField] Image image3;
    [SerializeField] Image image4;
    [SerializeField] Image image5;

    
    [SerializeField] GameObject PlayButton;
        [SerializeField] GameObject thisMenu;
        [SerializeField] GameObject mainMenu;
        [SerializeField] GameObject scene;

    [SerializeField] Sprite firecrystal;
    [SerializeField] Sprite watercrystal;
    [SerializeField] Sprite earthcrystal;
[SerializeField] Sprite windcrystal;

    [SerializeField] Sprite firetoken;
    [SerializeField] Sprite watertoken;
    [SerializeField] Sprite earthtoken;
    [SerializeField] Sprite windctoken;
[SerializeField] Sprite monster1;
[SerializeField] Sprite monster2;
[SerializeField] Sprite firesofhell;
[SerializeField] Sprite lavafloor;
[SerializeField] Sprite lavabg;
[SerializeField] Sprite altar;
[SerializeField] Sprite earthkingdom;

[SerializeField] Sprite natureprincessfar;
[SerializeField] Sprite natureprincessclose
;
    int counter=0;
    // Start is called before the first frame update



public void backToMainMenu(){
    thisMenu.SetActive(false);
    mainMenu.SetActive(true);
}

public void SkipAndPlay(){
    thisMenu.SetActive(false);
    SceneManager.LoadScene("level1");

}
public void ChangeStory(){
    if (counter==0){
                PlayButton.gameObject.SetActive(true);

        Debug.Log("hi");
        storyText.SetText("Until one day, the fire kingdom got greedy, and decided to take control and destroy everything.");
        mainImage.sprite=lavabg;
        counter++;
    }
    else  if (counter==1){
        storyText.SetText("Your mission is to kill the hell monsters...");
        mainImage.gameObject.SetActive(false);
        largeimage1.sprite=monster1;
        largeimage2.sprite=monster2;
        largeimage1.gameObject.SetActive(true);
        largeimage2.gameObject.SetActive(true);

        counter++;
    }
       else if (counter==2){
        storyText.SetText("Collect the crystals of the four elements...");
        largeimage1.gameObject.SetActive(false);
        largeimage2.gameObject.SetActive(false);
        image2.sprite=earthcrystal;
        image3.sprite=firecrystal;
        image4.sprite=windcrystal;
        image5.sprite=watercrystal;
        image2.gameObject.SetActive(true);
        image3.gameObject.SetActive(true);
        image4.gameObject.SetActive(true);
        image5.gameObject.SetActive(true);


      
        counter++;
    }

    else if (counter==3){
        storyText.SetText("Jump over the lava and extinguish the fires of hell to escape death...");
        image2.gameObject.SetActive(false);
        image3.gameObject.SetActive(false);
        image4.gameObject.SetActive(false);
        image5.gameObject.SetActive(false);
        largeimage1.sprite=firesofhell;
        largeimage2.sprite= lavafloor;
        largeimage1.gameObject.SetActive(true);
        largeimage2.gameObject.SetActive(true);
        counter++;
    }

        else if (counter==4){

  storyText.SetText("Collect the tokens of the four elements...");
        largeimage1.gameObject.SetActive(false);
        largeimage2.gameObject.SetActive(false);
        image2.sprite=earthtoken;
        image3.sprite=firetoken;
        image5.sprite=windctoken;
        image4.sprite=watertoken;
        image2.gameObject.SetActive(true);
        image3.gameObject.SetActive(true);
        image4.gameObject.SetActive(true);
        image5.gameObject.SetActive(true);
                counter++;


        }

        else if (counter==5){
        storyText.SetText("Take the crystals and the tokens of the four elements to the kingdom of the earth and place them at the altar...");
        image2.gameObject.SetActive(false);
        image3.gameObject.SetActive(false);
        image4.gameObject.SetActive(false);
        image5.gameObject.SetActive(false);
        largeimage1.sprite=earthkingdom;
        largeimage2.sprite= altar;
        largeimage1.gameObject.SetActive(true);
        largeimage2.gameObject.SetActive(true);
        counter++;
        }

        else if (counter==6){
        storyText.SetText("So that the tower gate can open, and you can finally free the princess of nature, to regain the balance and harmony the kingdoms once knew...");
        largeimage1.sprite=natureprincessfar;
        largeimage2.sprite= natureprincessclose;
        PlayButton.gameObject.SetActive(false);
        this.GetComponentInChildren<Text>().text="Play";
        counter++;
        }

                else if (counter==7){

    SceneManager.LoadScene("level1");


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
