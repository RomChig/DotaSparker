export const secondsToMinutesConverter = digit => {
    digit = Number(digit);
    const h = Math.floor(digit / 3600);
    const m = Math.floor(digit % 3600 / 60);
    const s = Math.floor(digit % 3600 % 60);
    return ('0' + h).slice(-2) + ":" + ('0' + m).slice(-2) + ":" + ('0' + s).slice(-2);
}