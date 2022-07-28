using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;

public class Story : MonoBehaviour
{




    [SerializeField] TMP_Text storyText;
    [SerializeField] Image storyImage;
    [SerializeField] GameObject PlayButton;

    [SerializeField] Sprite sprite1;
        [SerializeField] Sprite sprite2;

    [SerializeField] Sprite sprite3;

    int counter=0;
    // Start is called before the first frame update


public void ChangeStory(){
    if (counter==0){
        storyText.SetText("All the creatures lived happily and in peace, until one day, the enemies arrived...They had one goal in mind : Destroying the forest by stealing its crystals... ");
        storyImage.sprite=sprite1;
        counter++;
    }
    else  if (counter==1){
        storyText.SetText("Your mission is to kill the enemies, seize the crystals, and take them to the sacred Temple...");
        storyImage.sprite=sprite2;
        counter++;
    }
       else if (counter==2){
        storyText.SetText("So that one day, our forest can breath again...");
        storyImage.sprite=sprite3;
        counter++;
    }

    else if (counter==3){
        gameObject.SetActive(false);
        PlayButton.SetActive(true);
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
