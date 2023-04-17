export class Equipe {
  public get vote(): number {
    return this._vote;
  }
  public set vote(value: number) {
    this._vote = value;
  }
  public get equipe(): string {
    return this._equipe;
  }
  public set equipe(value: string) {
    this._equipe = value;
  }
  public constructor(private _equipe: string, private _vote: number = 0) {}
}
