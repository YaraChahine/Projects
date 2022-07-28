using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class MeterDisplay : MonoBehaviour
{


    public MeterSO meter;
    public Image frame;
    public Image mask;
    public Image fill;
    public Image Case;
    
    
    void Start()
    {
        frame.sprite=meter.frame;
        mask.sprite=meter.mask;
        fill.sprite=meter.fill;
        Case.sprite=meter.Case;
    }

    
    void Update()
    {
        
    }
}
