package com.localiza.jdc.designsystem.ui_components.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.localiza.jdc.designsystem.R
import com.localiza.jdc.designsystem.ui_components.theme.Gray30
import com.localiza.jdc.designsystem.ui_components.theme.Gray50
import com.localiza.jdc.designsystem.ui_components.theme.Green20
import com.localiza.jdc.designsystem.ui_components.theme.Green30
import com.localiza.jdc.designsystem.ui_components.theme.Green80
import com.localiza.jdc.designsystem.ui_components.theme.LECOPrimaryEnabledNormalNoIcon
import com.localiza.jdc.designsystem.ui_components.theme.LocalizaJDCMaterialTheme
import com.localiza.jdc.designsystem.ui_components.theme.Mint70
import com.localiza.jdc.designsystem.ui_components.theme.RACPrimaryEnabledNormalNoIcon
import com.localiza.jdc.designsystem.ui_components.theme.Typography

@Composable
fun LocalizaButton(
    modifier: Modifier,
    text: String,
    isLECO: Boolean,
    @DrawableRes iconStart: Int? = null,
    @DrawableRes iconEnd: Int? = null,
    onClick: () -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) {
        if (isLECO) Green30 else Mint70
    } else {
        if (isLECO) Green20 else Green80
    }

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = if (isLECO) Color.Black else Color.White,
            disabledBackgroundColor = Gray30,
            disabledContentColor = Gray50
        ),
        onClick = {
            selected = !selected
            onClick()
        }
    ) {
        if (iconStart != null)
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = iconStart),
                contentDescription = stringResource(id = R.string.button_icon_content_description)
            )
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
        if (iconEnd != null)
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = iconEnd),
                contentDescription = stringResource(id = R.string.button_icon_content_description)
            )
    }
}

@Preview
@Composable
fun previewRACPrimaryButton() {
    LocalizaJDCMaterialTheme {
        Column {
            LocalizaButton(
                isLECO = false,
                modifier = RACPrimaryEnabledNormalNoIcon.fillMaxWidth(),
                text = "Compras",
                onClick = {},
                iconEnd = R.drawable.carrinho_de_compras
            )
        }
    }
}

@Composable
fun previewLECOPrimaryButton() {
    LocalizaJDCMaterialTheme {
        Surface {
            Column {
                Text(text = "Bem-vindo ao Assistência Localiza!")
                LocalizaButton(
                    isLECO = true,
                    modifier = LECOPrimaryEnabledNormalNoIcon.fillMaxWidth(),
                    text = "Neutralização de Carbono",
                    onClick = {},
                    iconStart = R.drawable.neutraliza
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun previewAssistenciaLocalizaLECOPrimaryButton() {
    LocalizaJDCMaterialTheme {
        Surface {
            Column {
                LocalizaTopAppBar()
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Bem-vindo ao Assistência Localiza!",
                    style = Typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(36.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LocalizaButton(
                    isLECO = true,
                    modifier = LECOPrimaryEnabledNormalNoIcon.fillMaxWidth().padding(36.dp),
                    text = "Verificar situação de guincho",
                    onClick = {},
                    iconStart = R.drawable.mensagem_alerta
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun previewLECOPrimaryButtonDark() {
    LocalizaJDCMaterialTheme {
        Surface {
            Column {
                LocalizaTopAppBar(isEndActionLECOLogo = false)
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Bem-vindo ao Assistência Localiza!",
                    style = Typography.h5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(36.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LocalizaButton(
                    isLECO = false,
                    modifier = LECOPrimaryEnabledNormalNoIcon.fillMaxWidth().padding(36.dp),
                    text = "Verificar situação de guincho",
                    onClick = {},
                    iconStart = R.drawable.mensagem_alerta
                )
            }
        }
    }
}