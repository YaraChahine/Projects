using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

public class TextUI : MonoBehaviour
{
    [SerializeField] TMP_Text text;
    [SerializeField] Animator animator;

    
   private void OnEnable() {
        Player.OnLoad += decreaseTime;
        Debug.Log("time");
    }

    private void OnDisable() {
         Player.OnLoad-= decreaseTime;
    }
    void decreaseTime(GameObject myPlayer){
        StartCoroutine(decreaseTimeCoroutine(5.0f,myPlayer));

    }

    IEnumerator decreaseTimeCoroutine(float time,GameObject myPlayer){
        while(time>=0){
            Debug.Log(time);
            text.text = time.ToString();
            time--;
            yield return new WaitForSeconds(1);
    }
    Debug.Log("AHIFHAFAF");
    myPlayer.SetActive(true);
    this.gameObject.SetActive(false);
    animator.SetLayerWeight(1, 0f);
}

}