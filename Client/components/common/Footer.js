import styled from 'styled-components'
import Link from 'next/link'
import  IcoInstagram from '@/public/icons/Instagram'
import  IcoFace from '@/public/icons/Facebook'
import  IcoYoutube from '@/public/icons/Youtube'
import  IcoTik from '@/public/icons/Tiktok'

export const Footer = () => {
  return(
    <FooterContainer>
      
      <div className='container'>
        <Item>
          <h2  className='title'> Contáctanos!</h2>
          &nbsp;
          &nbsp;
          <Link href="https://goo.gl/maps/ee8VUcUW2sCa14XQ6">
            <p>Remedios de Escalada de San Martin 3875</p>
            <p>Floresta(CABA)</p>
          </Link>
          <br/> 
          <Link href='https://goo.gl/maps/bTbq5mB3SZBayFGZA'>            
            <p>Florida 537 PB, Local 379</p>
            <p>Microcentro (CABA)</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Whatsaap: +54 11 2357-5588</p>
          </Link>
          <br/>
          <a href='mailito:empresas@maximus.com.ar'>empresas@maximus.com.ar</a>
        </Item>
        <Item>
          <h2 className='title'>Nuestros Horarios</h2>
          &nbsp;
          &nbsp;
          <Link href='#'>
            <p>Floresta<br/>
            Lun a Vie. 9:00 AM 18:00PM<br/>
            Sab 10:00 AM - 14:30PM.</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Florida Local<br/>
            Lun a Vier, 10:00 AM a 19:00 PM<br/>
            Sab 10:00 AM - 14:30 PM</p>
          </Link>
        </Item>
        <Item>
          <h2 className='title'>Ayuda</h2>
          &nbsp;
          &nbsp;
          <Link href='#'>
            <p>FAQ</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Trámite Garantía</p>
          </Link>
          &nbsp;
          <Link href='#'>
            <p>Boton de Arrepentimiento</p>
          </Link>
        </Item>
        <Item>
          <h2 className='title'>Seguinos en las Redes</h2>          
          <br/>
          <Link className='inst' href='#'>
            <IcoInstagram />          
          </Link>
          <Link className='face' href='#'>
            <IcoFace />
          </Link>
          <Link className='inst' href='#'>
            <IcoYoutube />
          </Link>
          <Link href='#'>
            <IcoTik />
          </Link>
        </Item>
      </div>
    </FooterContainer>
  )
}

const FooterContainer = styled.div`
  background-color: var(--secondaryViolet1);
  width: 100%;
  color: white;
  padding: 5rem 0;
  margin-top: 20rem;
  .container{
    margin-left: 2em;
    margin-right: 2em;
    display: flex;    
    justify-content: space-between;
    gap: 5em;
  }
 `
const Item = styled.div`
  .title {
    font-style: italic;
    font-size: 20px;
    color: var(--primaryGreen1)
  }
  p{
    font-size: 12px;
  }
  p:hover{
    color:var(--primaryGreen1)
  }
  a {
    font-size: 12px;
  }
  a:hover{
    color:var(--primaryGreen1)
  }
  .inst:hover{
    color:red;
  }
  .face:hover{
    color: blue;
  }
`
