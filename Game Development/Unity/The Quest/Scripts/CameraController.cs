using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Cinemachine;
public class CameraController : MonoBehaviour
{
    [SerializeField] CinemachineVirtualCamera aimCamera;
    [SerializeField] GameObject bullet;
    [SerializeField] Transform bulletSpawn;
    [SerializeField] GameObject weapon;
    [SerializeField] Transform bullets;
    [SerializeField] Transform BulletPoolParent;
    [SerializeField] float speed = 150f;

    [SerializeField] List<GameObject> bulletPool = new List<GameObject>();



    Animator animator;

    RaycastHit info;
    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();
        animator.SetLayerWeight(1, 0f);
        foreach(Transform obj in bullets){
            obj.gameObject.SetActive(false);
            bulletPool.Add(obj.gameObject);
        }
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetMouseButtonDown(1)){
            aimCamera.gameObject.SetActive(true);
            weapon.SetActive(true);
            animator.SetLayerWeight(1,1f);
        }if(Input.GetMouseButtonUp(1)){
            aimCamera.gameObject.SetActive(false);
            weapon.SetActive(false);
            animator.SetLayerWeight(1, 0f);
        }if(Input.GetMouseButtonDown(0) && weapon.activeSelf == true){
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            if(Physics.Raycast(ray, out info)){
                Vector3 direction = (info.point - bulletSpawn.position).normalized;
                if(bulletPool.Count == 0){
                GameObject obj = Instantiate(bullet,bulletSpawn.position,Quaternion.LookRotation(direction,Vector3.forward)) as GameObject;
                obj.transform.SetParent(bullets);
                StartCoroutine("addToBulletPool" , obj);
                }
                int randindex = Random.Range(0,bulletPool.Count);
                GameObject myBullet = bulletPool[randindex];
                bulletPool.Remove(myBullet);

                myBullet.GetComponent<Rigidbody>().velocity = transform.forward * speed * Time.deltaTime;

                myBullet.transform.position = bulletSpawn.position;


                myBullet.transform.rotation = Quaternion.LookRotation(direction,Vector3.forward);
                myBullet.transform.SetParent(BulletPoolParent);

                myBullet.SetActive(true);

            }
        }
    }
    public IEnumerator addToBulletPool(GameObject myObject){
        bulletPool.Add(myObject);
        myObject.transform.SetParent(bullets);
        myObject.SetActive(false);
        yield return new WaitForSeconds(1.0f);
    }

    void OnDrawGizmos(){
        Gizmos.color = Color.green;
        Gizmos.DrawCube(this.gameObject.transform.position,new Vector3(2, 5, 2));
    }

}
