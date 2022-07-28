using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
public class LoadNewLevel : MonoBehaviour
{

    public GameObject loadingScreenPanel;

    public Slider slider;
    public void LoadLevel(string sceneName){
        StartCoroutine(LoadAsync(sceneName));
    }
    IEnumerator LoadAsync(string sceneName){
        AsyncOperation operation = SceneManager.LoadSceneAsync(sceneName);
        loadingScreenPanel.SetActive(true);

        while(!operation.isDone){
            float progress = Mathf.Clamp01(operation.progress / 0.9f);
                slider.value = progress;
                yield return null;
        }
    }
}
