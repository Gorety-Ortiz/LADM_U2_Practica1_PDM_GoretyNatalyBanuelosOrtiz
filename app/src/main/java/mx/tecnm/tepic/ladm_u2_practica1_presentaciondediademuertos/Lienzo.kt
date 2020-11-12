package mx.tecnm.tepic.ladm_u2_practica1_presentaciondediademuertos


import android.graphics.*
import android.os.CountDownTimer
import android.view.View


class Lienzo(p: MainActivity): View(p)
{

    //VARIABLES PARA TIMER 1
    var calx1=-280f
    var caly1=980f
    var incrementoX1 = 5

    //VARIABLES PARA TIMER 2
    var calx2=1050f
    var caly2=1250f
    var incrementoX2 = 5

    //VARIABLES PARA TIMER 4
    var calx3=650f
    var caly3=750f
    var incrementoX3 = 5

    //VARIABLES PARA TIMER 3
    var imax=445f
    var imay=-2000f
    var incrementoim=0.05f

    var xC = 170f
    var yC = 200f

    var xC2 = 1100f
    var yC2 = 200f


    //ESQUELETOS DE IZQUIERDA A DERECHA
    val esqueleto2 = BitmapFactory.decodeResource(resources, R.drawable.img1)
    //TEMPLO
    val templo = BitmapFactory.decodeResource(resources, R.drawable.iglesia)
    //TUMBAS
    val tumba = BitmapFactory.decodeResource(resources, R.drawable.rip1)

    //ESQUELETOS DE ARRIBA HACIA ABAJO
    val esqueleto = BitmapFactory.decodeResource(resources, R.drawable.calaverita)

    //ESPECIFICACIONES DEL ESQUELETO2 EN EL TIMER
    var rcal1=Bitmap.createScaledBitmap(esqueleto2, 300, 300, true /* filter*/)
    var rcal2=Bitmap.createScaledBitmap(esqueleto2, 300, 300, true /* filter*/)
    var rcal3=Bitmap.createScaledBitmap(esqueleto2, 300, 300, true /* filter*/)

    //ESPECIFICACIONES DEL ESQUELETO EN EL TIMER
    var rcal4=Bitmap.createScaledBitmap(esqueleto, 200, 200, true /* filter*/)

    //TIMER'S DE LAS IMAGENES
    val timer = object : CountDownTimer(200000, 20000){
        override fun onTick(millisUntilFinished: Long) {
            calx1+=incrementoX1
            if(calx1<=-700||calx1>=1200)
            {
                incrementoX1 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer2 = object : CountDownTimer(200000, 20000){
        override fun onTick(millisUntilFinished: Long) {
            calx2+=incrementoX2
            if(calx2<=-700||calx2>=1200)
            {
                incrementoX2 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer4 = object : CountDownTimer(200000, 20000){
        override fun onTick(millisUntilFinished: Long) {
            calx3+=incrementoX3
            if(calx3<=-700||calx3>=1200)
            {
                incrementoX3 *=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }

    val timer3 = object : CountDownTimer(2000,100){
        override fun onTick(millisUntilFinished: Long) {
            imay+=incrementoim
            invalidate()
        }
        override fun onFinish() {
            start()
            if(incrementoim>100)
            {
                this.cancel()
            }
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        val p= Paint()

        //FONDO DEL CIELO
        c.drawARGB(255, 3, 13, 69)

        //Cielo
        //Luna
        p.setColor(Color.argb(255, 199, 208, 248))
        c.drawCircle(650f, 175f, 110f, p)
        // p.setColor(Color.argb(255, 3, 19, 79))
        p.setColor(Color.argb(255, 3, 13, 69))
        c.drawCircle(750f, 125f, 140f, p)

        //NUVES EN EL CIELO
        //NUVE IZQUIERDA - SOMBRA
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC, yC, 80f, p)
        c.drawCircle(xC - 100, yC + 50, 75f, p)
        c.drawCircle(xC + 100, yC + 50, 75f, p)
        c.drawCircle(xC, yC + 50, 75f, p)
        //NUVE IZQUIERDA - DELANTERA
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC, yC + 50, 75f, p)
        c.drawCircle(xC - 90, yC + 100, 75f, p)
        c.drawCircle(xC + 90, yC + 100, 75f, p)
        c.drawCircle(xC, yC + 100, 75f, p)

        //NUVE DERECHA - SOMBRA
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC2, yC2, 80f, p)
        c.drawCircle(xC2 - 100, yC2 + 50, 80f, p)
        c.drawCircle(xC2 + 100, yC2 + 50, 80f, p)
        c.drawCircle(xC2, yC2 + 50, 80f, p)
        //NUVE DERECHA - DELANTERA
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2, yC2 + 50, 80f, p)
        c.drawCircle(xC2 - 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2 + 90, yC2 + 100, 80f, p)
        c.drawCircle(xC2, yC2 + 100, 80f, p)



        //NUVE CENTRAR - SOMBRA
        p.setColor(Color.argb(255, 130, 130, 130))
        c.drawCircle(xC2 - 290, yC2 + 160, 70f, p)
        c.drawCircle(xC2 - 390, yC2 + 210, 70f, p)
        c.drawCircle(xC2 - 190, yC2 + 210, 70f, p)
        c.drawCircle(xC2 - 290, yC2 + 210, 70f, p)
        //NUVE CENTRAL - DELANTERA
        p.setColor(Color.argb(255, 155, 155, 155))
        c.drawCircle(xC2 - 290, yC2 + 210, 70f, p)
        c.drawCircle(xC2 - 390, yC2 + 260, 70f, p)
        c.drawCircle(xC2 - 190, yC2 + 260, 60f, p)
        c.drawCircle(xC2 - 290, yC2 + 260, 70f, p)

        //TEMPO DE LA IGLESIA
        p.setColor(Color.argb(255, 20, 118, 36))
        c.drawBitmap(templo, 370f, 345f, p)

        //TIERRA DE TUMBAS
        p.setColor(Color.argb(255, 255, 193, 7))
        c.drawRect(630f, 690f, 1080f, 1800f, p)//Camino derecho
        c.drawRect(0f, 690f, 460f, 1800f, p)//Camino izquierdo
        //CAMINO HACIA EL TEMPLO
        p.setColor(Color.argb(200, 255, 153, 0))
        c.drawRect(470f, 690f, 620f, 1800f, p)//camino de cempasuchil


        //PRIMERA HILERA DE TUMBAS
        c.drawBitmap(tumba, 265f, 800f, p)
        c.drawBitmap(tumba, 0f, 800f, p)
        c.drawBitmap(tumba, 920f, 800f, p)
        c.drawBitmap(tumba, 660f, 800f, p)

        //SEGUNDA HILERA DE TUMBAS
        c.drawBitmap(tumba, 265f, 1050f, p)
        c.drawBitmap(tumba, 0f, 1050f, p)
        c.drawBitmap(tumba, 920f, 1050f, p)
        c.drawBitmap(tumba, 660f, 1050f, p)

        //TERCERA HILERA DE TUMBAS
        c.drawBitmap(tumba, 265f, 1300f, p)
        c.drawBitmap(tumba, 0f, 1300f, p)
        c.drawBitmap(tumba, 920f, 1300f, p)
        c.drawBitmap(tumba, 660f, 1300f, p)

        //ESQUELETOS
        c.drawBitmap(rcal2,calx2,caly2,p)
        c.drawBitmap(rcal3,calx3,caly3,p)
        c.drawBitmap(rcal1,calx1,caly1,p)
        c.drawBitmap(rcal4,imax,imay,p)

        //ACTIVAR TIMER PARA LA ANIMACION
        timer.start()
        timer2.start()
        timer4.start()
        timer3.start()

    }
}