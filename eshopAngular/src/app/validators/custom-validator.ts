import {
  AbstractControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export class CustomValidator {
  public static totoInterdit(
    control: AbstractControl
  ): null | ValidationErrors {
    return control.value == 'toto' ? { toto: true } : null;
  }

  public static chaineInterdite(chaine: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == chaine ? { chaineInterdite: true } : null;
    };
  }

  public static controlsEgauxInterdit(
    control: AbstractControl
  ): ValidationErrors | null {
    let group = control as FormGroup;
    return group.get('testControlEgaux1')!.value ==
      group.get('testControlEgaux2')!.value
      ? { egalite: true }
      : null;
  }
}
