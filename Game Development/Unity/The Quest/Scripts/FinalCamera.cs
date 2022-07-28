using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FinalCamera : MonoBehaviour
{
    Transform camTransform;
    float time = 5.0f;
    
    void Start()
    {
        camTransform = this.gameObject.GetComponent<Transform>();
    }

    
    void OnEnable(){
        Debug.Log("hi");
        StartCoroutine(rotateCamera(5.0f));
    }
 IEnumerator rotateCamera(float time)
 {
     float start = transform.eulerAngles.y;
     float end = start+360; 
     float currentTime = 0.0f;
     while ( currentTime  < time )
     {
         currentTime += Time.deltaTime;
         float yRotation = Mathf.Lerp(start, end, currentTime / time) % 360.0f;
         transform.eulerAngles = new Vector3(transform.eulerAngles.x, yRotation, transform.eulerAngles.z);
         yield return null;
     }
 }









}
