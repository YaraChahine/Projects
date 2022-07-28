using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CheckpointGizmo : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

  void OnDrawGizmos(){
        Gizmos.color = Color.yellow;
        Gizmos.DrawCube(this.gameObject.transform.position,new Vector3(3, 3, 3));
    }

    

}
