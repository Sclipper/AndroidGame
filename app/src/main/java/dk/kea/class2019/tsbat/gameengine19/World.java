package dk.kea.class2019.tsbat.gameengine19;

public class World
{
    public static float MIN_X = 0;
    public static float MIN_Y = 36;
    public static float MAX_X = 319;
    public static float MAX_Y = 479;

    Ball ball = new Ball();
    Paddle paddle = new Paddle();

    public void update(float deltaTime, float accelX, boolean isTouch, int touchX)
    {
        ball.x = ball.x + ball.vx * deltaTime;
        ball.y = ball.y + ball.vy * deltaTime;

        // move peddle based on touch, only for testing in emulator!!!
        if (isTouch)
        {
            paddle.x = touchX - Paddle.WIDTH/2;
        }

        if (ball.x < MIN_X)
        {
            ball.vx = -ball.vx; //SO that we avoid a nasty loop
            ball.x = MIN_X;
        }

        if (ball.x > MAX_X - Ball.WIDTH)
        {
            ball.vx = -ball.vx;
            ball.x = MAX_X - Ball.WIDTH;
        }

        if (ball.y > MIN_Y)
        {
            ball.y = - ball.vy;
            ball.y = MIN_Y;
        }
        if (ball.y > MAX_Y - Ball.HEIGHT)
        {
            ball.vy = -ball.vy;
            ball.y = MAX_Y - Ball.HEIGHT;
        }
        paddle.x = paddle.x + accelX * 50 * deltaTime;
        if (paddle.x < MIN_X) paddle.x = MIN_X;
        if (paddle.x + Paddle.WIDTH> MAX_X ) paddle.x = MAX_X - Paddle.WIDTH;

        collideBallPaddle();
    }

    private void collideBallPaddle()
    {
        if (ball.y > paddle.y) return;
        if ((ball.x >= paddle.x) && (ball.x+Ball.WIDTH < paddle.x + Paddle.WIDTH) && (ball.y + Ball.HEIGHT > paddle.y))
        {
            ball.vy = -ball.vy;
        }
    }
}
