window.onload = function () {
  const screen = document.getElementById('text-area');
  const startButton = document.getElementById('start');
  const stopButton = document.getElementById('stop');
  const animationOption = document.getElementById('animation');
  const sizeOption = document.getElementById('fontsize');
  const speedCheckBox = document.getElementById('turbo');

  let currentFontClass = null;
  let selectedAnimation = window.ANIMATIONS[animationOption.value];
  let speed = 250;
  let player;

  const setScreen = (string) => {
    screen.innerHTML = '';
    screen.innerHTML = string;
  };

  const setFont = (font) => {
    const fontClass = `fs-${font}`;
    screen.classList.remove(currentFontClass);
    screen.classList.add(fontClass);
    currentFontClass = fontClass;
  };

  const setAnimation = (animation) => {
    if (animation === '') {
      return;
    }
    const animationAFramesArray = animation.split('=====\n');

    let counter = 0;
    player = setInterval(() => {
      if (counter >= animationAFramesArray.length) {
        counter = 0;
      }
      setScreen(animationAFramesArray[counter]);
      counter += 1;
    }, speed);
  };

  const restart = () => {
    clearInterval(player);
    setAnimation(selectedAnimation);
  };

  animationOption.onchange = (e) => {
    selectedAnimation = window.ANIMATIONS[e.target.value];
    setScreen(selectedAnimation);
  };

  sizeOption.onchange = (e) => {
    setFont(e.target[e.target.selectedIndex].dataset.fs);
  };

  startButton.onclick = (e) => {
    e.target.disabled = true;
    animationOption.disabled = true;
    stopButton.disabled = false;
    setAnimation(selectedAnimation);
  };

  stopButton.onclick = (e) => {
    e.target.disabled = true;
    startButton.disabled = false;
    animationOption.disabled = false;
    clearInterval(player);
    setScreen(selectedAnimation);
  };

  speedCheckBox.onchange = (e) => {
    speed = e.target.checked ? 50 : 250;
    restart();
  };
};