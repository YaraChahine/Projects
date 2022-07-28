using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Waypoints : MonoBehaviour
{
    [SerializeField] GameObject otherWayPoint;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    void OnDrawGizmos(){
        Gizmos.color = Color.blue;
        Gizmos.DrawSphere(this.gameObject.transform.position,1);
        Gizmos.DrawLine(this.gameObject.transform.position,otherWayPoint.transform.position);

        }
}
