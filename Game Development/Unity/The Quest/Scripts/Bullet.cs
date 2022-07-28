using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    GameObject player;
    [SerializeField] Rigidbody bullet;
    CameraController poolingScript;
    GameObject water_particles;

    [SerializeField] AudioSource audioSource;
    [SerializeField] AudioClip audioClip;


    [SerializeField] float speed = 150f;
    
    void Start()
    {
        player = GameObject.Find("PlayerArmature");
        water_particles = GameObject.Find("ShootParticleSystem");
        poolingScript = player.GetComponent<CameraController>();
        bullet = GetComponent<Rigidbody>();
        
        
    }
    void Update()
    {

    }

    
    void OnTriggerEnter(Collider other)
    {



        

        if (other.gameObject.tag == "Enemy")
        {        audioSource.PlayOneShot(audioClip);


            for (int i = 0; i < Player.enemies.Length; i++)
            {
                if (Player.enemies[i].name == other.gameObject.name)
                {
                    Debug.Log("hurrayayyyy");
                    Player.enemies_indices[i] = 0;
                }

            }



            
            
            
            Instantiate(water_particles, other.gameObject.transform.position, Quaternion.identity);
                        StartCoroutine(wait(this.gameObject));

            other.gameObject.SetActive(false);


            
        }
        
        
        
        
        
        

    }


    IEnumerator wait(GameObject bullet)
    {
        yield return new WaitForSeconds(1);
        StartCoroutine(poolingScript.addToBulletPool(this.gameObject));






    }
}
