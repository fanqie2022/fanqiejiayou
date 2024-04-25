import pygame
pygame.init()
screen_width, screen_height = 1280, 949
screen = pygame.display.set_mode((screen_width, screen_height))
clock = pygame.time.Clock()
tz = pygame.image.load("C:/Users/fanqi/Desktop/xm.jpg").convert()
run = True
while run:
    clock.tick(60)
    screen.blit(tz, (0, 0))
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        pygame.display.update()
pygame.quit()