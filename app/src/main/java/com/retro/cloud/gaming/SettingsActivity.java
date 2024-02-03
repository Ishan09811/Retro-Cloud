package com.retro.cloud.gaming;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.*;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import com.google.android.material.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.materialswitch.MaterialSwitch;


public class SettingsActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private TextView textview1;
	private LinearLayout linear2;
	private TextView textview2;
	private LinearLayout line_5;
	private LinearLayout linear3;
	private MaterialDivider line_1;
	private LinearLayout linear4;
	private MaterialDivider line_2;
	private TextView textview7;
	private MaterialDivider line_6;
	private LinearLayout linear6;
	private MaterialDivider line_3;
	private LinearLayout linear8;
	private MaterialDivider line_4;
	private LinearLayout linear9;
	private MaterialDivider line_7;
	private LinearLayout linear10;
	private MaterialDivider line_8;
	private MaterialSwitch switch1;
	private Switch switch2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private Switch switch4;
	private TextView textview6;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private TextView textview11;
	
	private PopupWindow pop;
	private SharedPreferences sherd;
	private PopupWindow pop2;
	private PopupWindow pop3;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		line_5 = findViewById(R.id.line_5);
		linear3 = findViewById(R.id.linear3);
		line_1 = findViewById(R.id.line_1);
		linear4 = findViewById(R.id.linear4);
		line_2 = findViewById(R.id.line_2);
		textview7 = findViewById(R.id.textview7);
		line_6 = findViewById(R.id.line_6);
		linear6 = findViewById(R.id.linear6);
		line_3 = findViewById(R.id.line_3);
		linear8 = findViewById(R.id.linear8);
		line_4 = findViewById(R.id.line_4);
		linear9 = findViewById(R.id.linear9);
		line_7 = findViewById(R.id.line_7);
		linear10 = findViewById(R.id.linear10);
		line_8 = findViewById(R.id.line_8);
		MaterialSwitch switch1 = findViewById(R.id.switch1);
		switch2 = findViewById(R.id.switch2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		switch4 = findViewById(R.id.switch4);
		textview6 = findViewById(R.id.textview6);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		sherd = getSharedPreferences("sherd", Activity.MODE_PRIVATE);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch1.isChecked()) {
					switch1.setChecked(false);
				}
				else {
					switch1.setChecked(true);
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch2.isChecked()) {
					switch2.setChecked(false);
				}
				else {
					switch2.setChecked(true);
				}
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				View popV = getLayoutInflater().inflate(R.layout.rp_dia, null);
				final PopupWindow pop = new PopupWindow(popV, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				final LinearLayout linear_items = popV.findViewById(R.id.linear1);
				final RadioButton radio_low = popV.findViewById(R.id.radiobutton1);
				final RadioButton radio_normal = popV.findViewById(R.id.radiobutton2);
				final TextView dia_ok = popV.findViewById(R.id.textview2);
				final RadioButton radio_high = popV.findViewById(R.id.radiobutton3);
				final RadioButton radio_remove = popV.findViewById(R.id.radiobutton4);
				pop.setAnimationStyle(android.R.style.Animation_Dialog);
				pop.showAsDropDown(linear6, 0,0);
				pop.setBackgroundDrawable(new BitmapDrawable());
				if (sherd.getString("rp", "").equals("low")) {
					textview5.setText("LOW");
					radio_low.setChecked(true);
				}
				else {
					if (sherd.getString("rp", "").equals("normal")) {
						textview5.setText("NORMAL");
						radio_normal.setChecked(true);
					}
					else {
						if (sherd.getString("rp", "").equals("high")) {
							textview5.setText("HIGH");
							radio_high.setChecked(true);
						}
						else {
							textview5.setText("NORMAL");
							radio_normal.setChecked(true);
						}
					}
				}
				radio_low.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						textview5.setText("LOW");
						radio_normal.setChecked(false);
						radio_high.setChecked(false);
						sherd.edit().putString("rp", "low").commit();
					}
				});
				radio_normal.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						textview5.setText("NORMAL");
						radio_low.setChecked(false);
						radio_high.setChecked(false);
						sherd.edit().putString("rp", "normal").commit();
					}
				});
				radio_high.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						textview5.setText("HIGH");
						radio_low.setChecked(false);
						radio_normal.setChecked(false);
						sherd.edit().putString("rp", "high").commit();
					}
				});
				dia_ok.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						pop.dismiss();
					}
				});
				radio_remove.setVisibility(View.GONE);
				_RippleEffect(radio_low, 0, 0, "#FF30323F", true);
				_RippleEffect(radio_normal, 0, 0, "#FF30323F", true);
				_RippleEffect(radio_high, 0, 0, "#FF30323F", true);
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch4.isChecked()) {
					switch4.setChecked(false);
				}
				else {
					switch4.setChecked(true);
				}
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				View pop2V = getLayoutInflater().inflate(R.layout.rp_dia, null);
				final PopupWindow pop2 = new PopupWindow(pop2V, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				final LinearLayout linear_items = pop2V.findViewById(R.id.linear1);
				final RadioButton radio_software = pop2V.findViewById(R.id.radiobutton1);
				final RadioButton radio_hardware = pop2V.findViewById(R.id.radiobutton3);
				final RadioButton radio_none = pop2V.findViewById(R.id.radiobutton2);
				final TextView dia_title = pop2V.findViewById(R.id.textview1);
				final TextView dia_ok = pop2V.findViewById(R.id.textview2);
				final RadioButton radio_remove = pop2V.findViewById(R.id.radiobutton4);
				pop2.setAnimationStyle(android.R.style.Animation_Dialog);
				pop2.showAsDropDown(linear9, 0,0);
				pop2.setBackgroundDrawable(new BitmapDrawable());
				linear_items.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
				if (sherd.getString("renderer_type", "").equals("hardware")) {
					radio_hardware.setChecked(true);
				}
				else {
					if (sherd.getString("renderer_type", "").equals("software")) {
						radio_software.setChecked(true);
					}
					else {
						radio_none.setChecked(true);
					}
				}
				dia_title.setText("Set Renderer Type");
				radio_software.setText("SOFTWARE");
				radio_none.setText("NONE");
				radio_hardware.setText("HARDWARE");
				radio_software.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("renderer_type", "software").commit();
						textview9.setText("SOFTWARE");
						radio_hardware.setChecked(false);
						radio_none.setChecked(false);
					}
				});
				radio_hardware.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("renderer_type", "hardware").commit();
						textview9.setText("HARDWARE");
						radio_software.setChecked(false);
						radio_none.setChecked(false);
					}
				});
				radio_none.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("renderer_type", "none").commit();
						textview9.setText("NONE");
						radio_hardware.setChecked(false);
						radio_software.setChecked(false);
					}
				});
				dia_ok.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						pop2.dismiss();
					}
				});
				radio_remove.setVisibility(View.GONE);
				_RippleEffect(radio_hardware, 0, 0, "#FF30323F", true);
				_RippleEffect(radio_software, 0, 0, "#FF30323F", true);
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				View pop3V = getLayoutInflater().inflate(R.layout.rp_dia, null);
				final PopupWindow pop3 = new PopupWindow(pop3V, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				final LinearLayout linear_items = pop3V.findViewById(R.id.linear1);
				final RadioButton radio_480p = pop3V.findViewById(R.id.radiobutton1);
				final RadioButton radio_720p = pop3V.findViewById(R.id.radiobutton2);
				final RadioButton radio_1080p = pop3V.findViewById(R.id.radiobutton3);
				final TextView dia_title = pop3V.findViewById(R.id.textview1);
				final TextView dia_ok = pop3V.findViewById(R.id.textview2);
				final RadioButton radio_auto = pop3V.findViewById(R.id.radiobutton4);
				pop3.setAnimationStyle(android.R.style.Animation_Dialog);
				pop3.showAsDropDown(linear10, 0,0);
				pop3.setBackgroundDrawable(new BitmapDrawable());
				if (sherd.getString("set_resolution", "").equals("480p")) {
					radio_480p.setChecked(true);
				}
				else {
					if (sherd.getString("set_resolution", "").equals("720p")) {
						radio_720p.setChecked(true);
					}
					else {
						if (sherd.getString("set_resolution", "").equals("1080p")) {
							radio_1080p.setChecked(true);
						}
						else {
							radio_auto.setChecked(true);
						}
					}
				}
				dia_title.setText("Set Resolution");
				radio_480p.setText("480P");
				radio_720p.setText("720P");
				radio_1080p.setText("1080P");
				radio_480p.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("set_resolution", "480p").commit();
						radio_720p.setChecked(false);
						radio_1080p.setChecked(false);
						radio_auto.setChecked(false);
						textview11.setText("480P");
					}
				});
				radio_720p.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("set_resolution", "720p").commit();
						radio_480p.setChecked(false);
						radio_1080p.setChecked(false);
						radio_auto.setChecked(false);
						textview11.setText("720P");
					}
				});
				radio_1080p.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("set_resolution", "1080p").commit();
						radio_480p.setChecked(false);
						radio_720p.setChecked(false);
						radio_auto.setChecked(false);
						textview11.setText("1080P");
					}
				});
				dia_ok.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						pop3.dismiss();
					}
				});
				radio_auto.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sherd.edit().putString("set_resolution", "auto").commit();
						radio_480p.setChecked(false);
						radio_720p.setChecked(false);
						radio_1080p.setChecked(false);
						textview11.setText("AUTO");
					}
				});
			}
		});
		
		switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                 if (isChecked) {
                    sherd.edit().putString("switch_fs", "on").commit();
             } else {
                    sherd.edit().putString("switch_fs", "off").commit();
               }
         });
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sherd.edit().putString("switch_hdm", "on").commit();
				}
				else {
					sherd.edit().putString("switch_hdm", "of").commit();
				}
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sherd.edit().putString("switch_st", "on").commit();
					SketchwareUtil.showMessage(getApplicationContext(), "on");
				}
				else {
					sherd.edit().putString("switch_st", "of").commit();
				}
			}
		});
	}
	
	private void initializeLogic() {
		linear1.setElevation((float)20);
		if (sherd != null && sherd.getString("switch_fs", "").equals("on")) {
                       switch1.setChecked(true);
                }
		else {
			switch1.setChecked(false);
		}
		if (sherd.getString("switch_hdm", "").equals("on")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
		}
		if (sherd.getString("rp", "").equals("low")) {
			textview5.setText("LOW");
		}
		else {
			if (sherd.getString("rp", "").equals("normal")) {
				textview5.setText("NORMAL");
			}
			else {
				if (sherd.getString("rp", "").equals("high")) {
					textview5.setText("HIGH");
				}
				else {
					
				}
			}
		}
		if (sherd.getString("switch_st", "").equals("on")) {
			switch4.setChecked(true);
		}
		else {
			switch4.setChecked(false);
		}
		if (sherd.getString("renderer_type", "").equals("hardware")) {
			textview9.setText("HARDWARE");
			getWindow().getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
		}
		else {
			if (sherd.getString("renderer_type", "").equals("software")) {
				textview9.setText("SOFTWARE");
				getWindow().getDecorView().setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			}
			else {
				textview9.setText("NONE");
				getWindow().getDecorView().setLayerType(View.LAYER_TYPE_NONE, null);
			}
		}
		if (sherd.getString("set_resolution", "").equals("480p")) {
			textview11.setText("480P");
		}
		else {
			if (sherd.getString("set_resolution", "").equals("720p")) {
				textview11.setText("720P");
			}
			else {
				if (sherd.getString("set_resolution", "").equals("1080p")) {
					textview11.setText("1080P");
				}
				else {
					textview11.setText("AUTO");
				}
			}
		}
		_RippleEffect(linear3, 0, 0, "#FF222629", true);
		_RippleEffect(linear4, 0, 0, "#FF222629", true);
		_RippleEffect(linear6, 0, 0, "#FF222629", true);
		_RippleEffect(linear8, 0, 0, "#FF222629", true);
		_RippleEffect(linear9, 0, 0, "#FF222629", true);
		_RippleEffect(linear10, 0, 0, "#FF222629", true);
	}
	
	public void _RippleEffect(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#FFFFFF")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
