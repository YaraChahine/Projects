using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Shooting : MonoBehaviour
{
    RaycastHit info;
    GameObject player;
    
    int enemyScore = 0;
[SerializeField] GameObject crystalsCollected;

 [SerializeField]
 GameObject allCrystalsCollected;
    [SerializeField]
    GameObject[] templeRocks;

    [SerializeField]
    TMP_Text enemyText;
    [SerializeField]
    TMP_Text arrowCount;

    [SerializeField]
    TMP_Text magicBallCount;
List<int>  templeRockIndex= new List<int>();
      [SerializeField]
    GameObject tCrystal;
    
    private bool found=false;
    
    [SerializeField] AudioClip audio1;
[SerializeField]  ParticleSystem Death_Particles;
    [SerializeField] AudioSource audioSrc;
    public static int arrows = 20;
    public static int magicBalls = 20;

    [SerializeField]

    GameObject spear;
 int counterCrystals=0;
[SerializeField] TMP_Text youWonText;
[SerializeField] GameObject youWonUI;
    [SerializeField]

    GameObject bow;
    // Start is called before the first frame update
    async void Start()
    {



           // Instantiate(Death_Particles,transform.position,Quaternion.identity);
           
            for (int i=0;i<templeRocks.Length;i++){
                templeRockIndex.Add(0);
            }
            player = GameObject.FindGameObjectWithTag("Player");
            magicBallCount.text = magicBalls.ToString();
            arrowCount.text = arrows.ToString();

                    audioSrc= GetComponent<AudioSource>();

    }

    // Update is called once per frame
    async void Update()
    {            

        magicBallCount.text = magicBalls.ToString();
        arrowCount.text = arrows.ToString();
        if(Input.GetButtonDown("Fire1")){
                                audioSrc.PlayOneShot(audio1);

            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if(Physics.Raycast(ray, out info)){

            if(info.collider.gameObject.tag == "templeRock"){
                if (allCrystalsCollected.activeSelf==false){

                for (int i=0;i<templeRocks.Length;i++){

                    
                    if (templeRocks[i]==info.collider.gameObject && templeRockIndex[i]==0){
            GameObject obj= Instantiate(tCrystal,info.point,Quaternion.identity) as GameObject;
                        templeRockIndex[i]=1;
                        counterCrystals++;
                        // for (int j=0;j<templeRocks.Length;j++){
                        //     if (templeRockIndex[j]==0){
                        //         found=true;
                        //     }
                        // }
                        if (counterCrystals==12){
                            youWonText.SetText("Congratulations! You won. Your score is "+ enemyScore.ToString());
                            youWonUI.SetActive(true);
                        }
                    }
                }}
                else{
                    StartCoroutine("appear");
                }

            }
                    Debug.Log(info.collider.gameObject.tag);
                
                if((info.collider.gameObject.tag == "Enemy" && spear.activeSelf==true && magicBalls>0 ) || (info.collider.gameObject.tag == "Enemy"  && arrows>0 )){
                  // info.collider.gameObject.GetComponent<ParticleSystem>().Play();

                    Destroy(info.collider.gameObject);
                    Instantiate(Death_Particles,info.point,Quaternion.identity);

                                   

                    info.collider.gameObject.GetComponent<Enemy>().setHealth(info.collider.gameObject.GetComponent<Enemy>().getHealth()-100);
                    if(info.collider.gameObject.GetComponent<Enemy>().getHealth()==0){
                                    
                    enemyScore++;
                    enemyText.text = $"Score: {enemyScore}";
                    }
                }
            }
                if(spear.activeSelf==true && magicBalls>0){
                    magicBalls--;
                    magicBallCount.text = magicBalls.ToString();
                }else if(bow.activeSelf==true && arrows>0){
                    arrows--;
                    arrowCount.text = arrows.ToString();
                }
        }
    }


         IEnumerator appear(){
         crystalsCollected.SetActive(true);
         yield return new WaitForSeconds(2);
         crystalsCollected.SetActive(false);
     }
}
